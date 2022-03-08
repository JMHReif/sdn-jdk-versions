//Github project source: https://raw.githubusercontent.com/marchof/java-almanac/

//Setup:
CREATE INDEX java_version FOR (j:JavaVersion) ON (j.version);

//Queries:
//1) Load Java versions, along with related sources, features, and refs
WITH [1.0,1.1,1.2,1.3,1.4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19] as versions
UNWIND versions as version
CALL apoc.load.json("https://raw.githubusercontent.com/marchof/java-almanac/master/site/data/jdk/versions/"+version+".json")
YIELD value as values
UNWIND values as value
    CREATE (j:JavaVersion {version: value.version})
     SET j.name = value.name, j.codeName = value.codename,
     j.gaDate = date(apoc.date.convertFormat(value.ga,"yyyy-MM-dd","iso_date")),
     j.status = value.status, j.bytecode = value.bytecode, j.vmSpec = value.documentation.vm,
     j.languageSpec = value.documentation.lang, j.apiSpec = value.documentation.api
    WITH value, j, trim(split(value.eol, "(")[0]) as dateString
    WITH value, j, dateString, split(dateString,"-") as dateParts
    WITH value, j, dateString, (CASE
        WHEN size(dateString) = 7 THEN date({year: toInteger(dateParts[0]), month: toInteger(dateParts[1])})
        WHEN size(dateString) = 10 THEN date({year: toInteger(dateParts[0]), month: toInteger(dateParts[1]), day: toInteger(dateParts[2])})
        ELSE date(dateString)
        END) as eolDate
     SET j.eolDate = eolDate
WITH value, j
CALL {
    WITH value, j
    UNWIND value.scm as scm
        MERGE (s:SourceCode {type: scm.type})
         ON CREATE SET s.sourceURL = scm.url
        MERGE (j)-[:MANAGED_BY]-(s)
}
WITH value, j
CALL {
    WITH value, j
    UNWIND value.features as feature
        MERGE (f:Feature {title: feature.title})
         ON CREATE SET f.category = feature.category
        WITH value, j, feature, f
        UNWIND feature.refs as ref
            MERGE (r:Reference {id: ref.identifier})
             ON CREATE SET r.type = ref.type
            MERGE (f)-[:HAS]->(r)
            WITH value, j, f
            MERGE (j)-[:INCLUDES]->(f)
}

//2) Load Java version diffs for each version
CALL apoc.periodic.iterate('MATCH (j:JavaVersion)
    WHERE toFloat(j.version) >= 1.1
    WITH j.version as version ORDER BY toFloat(version)
    WITH collect(version) as list
    UNWIND list as startVersion
    WITH startVersion, list[0..apoc.coll.indexOf(list, startVersion)] as prevList
    WITH startVersion, prevList
    WHERE size(prevList) > 0
    UNWIND prevList as prevVersion
    RETURN startVersion, prevVersion',
'CALL apoc.load.json("https://raw.githubusercontent.com/marchof/java-almanac/master/site/data/jdk/versions/"+startVersion+"/apidiff/"+prevVersion+".json", null, {failOnError:false})
YIELD value
MATCH (start:JavaVersion {version: startVersion})
MATCH (prev:JavaVersion {version: prevVersion})
WITH value, start, prev
CREATE (d:VersionDiff {fromVersion: value.base.version, toVersion: value.target.version})
 SET d.fromVendor = value.base.vendor, d.toVendor = value.target.vendor
CREATE (start)-[:NEWER]->(d)<-[:OLDER]-(prev)
WITH value, d
UNWIND value.deltas as level1Delta
WITH level1Delta, d
CALL apoc.create.node([apoc.text.capitalize(level1Delta.type),"Delta"], {name: level1Delta.name, docURL: level1Delta.javadoc, csr: level1Delta.csr, status: level1Delta.status, tags: level1Delta.addedTags})
YIELD node as node1
CREATE (d)-[:HAS_DELTA]->(node1)
WITH level1Delta, node1
UNWIND level1Delta.deltas as level2Delta
    WITH level2Delta, node1
    CALL apoc.create.node([apoc.text.capitalize(level2Delta.type),"Delta"], {name: level2Delta.name, docURL: level2Delta.javadoc, csr: level2Delta.csr, status: level2Delta.status, tags: level2Delta.addedTags})
        YIELD node as node2
    WITH level2Delta, node1, node2
    CREATE (node1)-[:HAS_DELTA]->(node2)
    WITH level2Delta, node2
    UNWIND level2Delta.deltas as level3Delta
        WITH level3Delta, node2
            CALL apoc.create.node([apoc.text.capitalize(level3Delta.type),"Delta"],{name: level3Delta.name, docURL: level3Delta.javadoc, csr: level3Delta.csr, status: level3Delta.status, tags: level3Delta.addedTags})
                YIELD node as node3
        WITH level3Delta, node2, node3
        CREATE (node2)-[:HAS_DELTA]->(node3)
        WITH level3Delta, node3
        UNWIND level3Delta.deltas as level4Delta
            WITH level4Delta, node3
            CALL apoc.merge.node([apoc.text.capitalize(level4Delta.type),"Delta"],{name: level4Delta.name}, {}, {name: level4Delta.name, docURL: level4Delta.javadoc, csr: level4Delta.csr, status: level4Delta.status, tags: level4Delta.addedTags})
                YIELD node as node4
            WITH level4Delta, node3, node4
            CREATE (node3)-[:HAS_DELTA]->(node4)
', {batchSize:50})

//3) Merge Method and Field nodes down
MATCH (b:Method) WITH collect(distinct(b.docURL)) as docURLs UNWIND docURLs as docURL MATCH (n:Method) where n.docURL = docURL WITH collect(n) as nodes, docURL CALL apoc.refactor.mergeNodes(nodes, {properties:"overwrite", mergeRels: true}) yield node RETURN count(node)
MATCH (b:Field) WITH collect(distinct(b.docURL)) as docURLs UNWIND docURLs as docURL MATCH (n:Field) where n.docURL = docURL WITH collect(n) as nodes, docURL CALL apoc.refactor.mergeNodes(nodes, {properties:"overwrite", mergeRels: true}) yield node RETURN count(node)

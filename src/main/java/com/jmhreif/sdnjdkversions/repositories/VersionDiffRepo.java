package com.jmhreif.sdnjdkversions.repositories;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface VersionDiffRepo extends Neo4jRepository<VersionDiff, Long> {

    @Query("MATCH (:JavaVersion {version: $version})-[:NEWER]->(v:VersionDiff)-[r1:HAS_DELTA]->(d1) RETURN v, collect(r1), collect(d1);")
    Iterable<VersionDiff> findVersionDiffsBy(String version);

    @Query("MATCH (:JavaVersion {version: $newer})-[:NEWER]->(v:VersionDiff)<-[:OLDER]-(:JavaVersion {version: $older})" +
            "MATCH (v)-[r1:HAS_DELTA]->(d1) RETURN v, collect(r1), collect(d1);")
    VersionDiff findVersionDiffBetween(String newer, String older);
}

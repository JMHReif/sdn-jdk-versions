package com.jmhreif.sdnjdkversions.repositories;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface VersionDiffRepo extends Neo4jRepository<VersionDiff, Long> {

    @Query("MATCH (:JavaVersion {version: $from})-[:FROM_NEWER]->(v:VersionDiff)-[r1:HAS_DELTA]->(d1)-[r2:HAS_DELTA]->(d2) RETURN v, collect(r1), collect(d1), collect(r2), collect(d2);")
    Iterable<VersionDiff> findVersionDiffsBy(String from);

    @Query("MATCH (:JavaVersion {version: $from})<-[:TO_OLDER]-(v:VersionDiff)<-[:FROM_NEWER]-(:JavaVersion {version: $to})" +
            "MATCH (v)-[r1:HAS_DELTA]->(d1)-[r2:HAS_DELTA]->(d2) RETURN v, collect(r1), collect(d1), collect(r2), collect(d2);")
    VersionDiff findVersionDiffBetween(String from, String to);
}

package com.jmhreif.sdnjdkversions.repositories;

import com.jmhreif.sdnjdkversions.domain.JavaVersion;
import com.jmhreif.sdnjdkversions.domain.JavaVersionProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface JavaVersionRepo extends Neo4jRepository<JavaVersion, String> {
    @Query("MATCH (v:JavaVersion)-[r:FROM_NEWER|FROM_OLDER]->(d:VersionDiff) RETURN v, collect(r), collect(d);")
    List<JavaVersion> findConnectedDiffs();

    @Query("MATCH (v:JavaVersion)-[r:FROM_NEWER]->(d:VersionDiff)" +
            "RETURN v, collect(r), collect(d);")
    List<JavaVersionProjection> findAllJavaVersionProjections();
}

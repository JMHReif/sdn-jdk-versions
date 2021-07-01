package com.jmhreif.sdnjdkversions.repositories;

import com.jmhreif.sdnjdkversions.domain.JavaVersion;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface JavaVersionRepo extends Neo4jRepository<JavaVersion, String> {
}

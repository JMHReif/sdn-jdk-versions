package com.jmhreif.sdnjdkversions.repositories;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VersionDiffRepo extends Neo4jRepository<VersionDiff, Long> {
}

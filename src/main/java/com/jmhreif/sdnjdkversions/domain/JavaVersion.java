package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.List;

@Node
public class JavaVersion {
    @Id
    @Property("version")
    private final String javaVersion;

    private String name;
    private String status;
    private String codeName;
    private LocalDate gaDate;
    private LocalDate eolDate;
    private String apiSpec;

    @Relationship("FROM_NEWER")
    private List<VersionDiff> olderVersionDiffs;

    @Relationship(value = "FROM_OLDER",direction = Relationship.Direction.INCOMING)
    private List<VersionDiff> newerVersionDiffs;

    public JavaVersion(String javaVersion, String name, String status, String codeName, LocalDate gaDate, LocalDate eolDate, String apiSpec) {
        this.javaVersion = javaVersion;
        this.name = name;
        this.status = status;
        this.codeName = codeName;
        this.gaDate = gaDate;
        this.eolDate = eolDate;
        this.apiSpec = apiSpec;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getCodeName() {
        return codeName;
    }

    public LocalDate getGaDate() {
        return gaDate;
    }

    public LocalDate getEolDate() {
        return eolDate;
    }

    public String getApiSpec() {
        return apiSpec;
    }

    public List<VersionDiff> getOlderVersionDiffs() {
        return olderVersionDiffs;
    }

    public List<VersionDiff> getNewerVersionDiffs() {
        return newerVersionDiffs;
    }
}

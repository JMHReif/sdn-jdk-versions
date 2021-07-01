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
    private List<VersionDiff> compareOlderList;

    @Relationship(value = "TO_OLDER",direction = Relationship.Direction.INCOMING)
    private List<VersionDiff> compareNewerList;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public LocalDate getGaDate() {
        return gaDate;
    }

    public void setGaDate(LocalDate gaDate) {
        this.gaDate = gaDate;
    }

    public LocalDate getEolDate() {
        return eolDate;
    }

    public void setEolDate(LocalDate eolDate) {
        this.eolDate = eolDate;
    }

    public String getApiSpec() {
        return apiSpec;
    }

    public void setApiSpec(String apiSpec) {
        this.apiSpec = apiSpec;
    }

    public List<VersionDiff> getCompareOlderList() {
        return compareOlderList;
    }

    public void setCompareOlderList(List<VersionDiff> compareOlderList) {
        this.compareOlderList = compareOlderList;
    }

    public List<VersionDiff> getCompareNewerList() {
        return compareNewerList;
    }

    public void setCompareNewerList(List<VersionDiff> compareNewerList) {
        this.compareNewerList = compareNewerList;
    }
}

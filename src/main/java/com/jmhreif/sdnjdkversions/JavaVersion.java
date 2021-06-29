package com.jmhreif.sdnjdkversions;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;

@Node
public class JavaVersion {
    @Id
    private final String javaVersion;

    private String name;
    private String status;
    private String codeName;
    private Date gaDate;
    private Date eolDate;
    private String apiSpec;

    public JavaVersion(String javaVersion, String name, String status, String codeName, Date gaDate, Date eolDate, String apiSpec) {
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

    public Date getGaDate() {
        return gaDate;
    }

    public void setGaDate(Date gaDate) {
        this.gaDate = gaDate;
    }

    public Date getEolDate() {
        return eolDate;
    }

    public void setEolDate(Date eolDate) {
        this.eolDate = eolDate;
    }

    public String getApiSpec() {
        return apiSpec;
    }

    public void setApiSpec(String apiSpec) {
        this.apiSpec = apiSpec;
    }
}

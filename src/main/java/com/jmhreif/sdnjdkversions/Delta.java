package com.jmhreif.sdnjdkversions;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public abstract class Delta {
    @Id
    @GeneratedValue
    private final Long neoId;

    private String name;
    private String docURL;
    private String status;

    public Delta(Long neoId, String name, String docURL, String status) {
        this.neoId = neoId;
        this.name = name;
        this.docURL = docURL;
        this.status = status;
    }

    public Long getNeoId() {
        return neoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocURL() {
        return docURL;
    }

    public void setDocURL(String docURL) {
        this.docURL = docURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

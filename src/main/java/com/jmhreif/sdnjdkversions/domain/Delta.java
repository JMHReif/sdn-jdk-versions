package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

public abstract class Delta {

    private String name;
    private String docURL;
    private String status;


    @Relationship("HAS_DELTA")
    private List<Delta> deltas;
    public List<Delta> getDeltas() {
        return deltas;
    }


    public Delta(String name, String docURL, String status) {
        this.name = name;
        this.docURL = docURL;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDocURL() {
        return docURL;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Delta (" + getClass().getSimpleName() + "){" +
                "name='" + name + '\'' +
                "status='" + status + '\'' +
                ", deltas=" + deltas +
                '}';
    }
}

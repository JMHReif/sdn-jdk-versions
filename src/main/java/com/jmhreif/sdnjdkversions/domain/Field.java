package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Field extends Delta {
    @Id
    @GeneratedValue
    private final Long neoId;

    public Field(String name, String docURL, String status, Long neoId) {
        super(name, docURL, status);
        this.neoId = neoId;
    }

    public Long getNeoId() {
        return neoId;
    }
}

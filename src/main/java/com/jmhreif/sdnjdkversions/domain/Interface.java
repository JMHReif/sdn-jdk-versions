package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Interface extends Delta {
    @Id
    @GeneratedValue
    private final Long neoId;

    @Relationship("HAS_DELTA")
    private List<Field> fields;

    @Relationship("HAS_DELTA")
    private List<Method> methods;

    public Interface(String name, String docURL, String status, Long neoId) {
        super(name, docURL, status);
        this.neoId = neoId;
    }

    public Long getNeoId() {
        return neoId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Method> getMethods() {
        return methods;
    }
}

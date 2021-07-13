package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Package extends Delta {
    @Id
    @GeneratedValue
    private final Long neoId;

    @Relationship("HAS_DELTA")
    private List<Annotation> annotations;

    @Relationship("HAS_DELTA")
    private List<Class> classes;

    @Relationship("HAS_DELTA")
    private List<Enum> enums;

    @Relationship("HAS_DELTA")
    private List<Interface> interfaces;

    public Package(String name, String docURL, String status, Long neoId) {
        super(name, docURL, status);
        this.neoId = neoId;
    }

    public Long getNeoId() {
        return neoId;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public List<Enum> getEnums() {
        return enums;
    }

    public List<Interface> getInterfaces() {
        return interfaces;
    }
}

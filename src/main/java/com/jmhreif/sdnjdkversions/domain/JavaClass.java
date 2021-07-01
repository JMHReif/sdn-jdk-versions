package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("Class")
public class JavaClass extends Delta {
    public JavaClass(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

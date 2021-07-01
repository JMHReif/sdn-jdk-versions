package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("Interface")
public class JavaInterface extends Delta {
    public JavaInterface(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

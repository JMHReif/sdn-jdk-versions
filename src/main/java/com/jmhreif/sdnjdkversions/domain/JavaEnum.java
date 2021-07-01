package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("Enum")
public class JavaEnum extends Delta {
    public JavaEnum(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

package com.jmhreif.sdnjdkversions;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Module extends Delta {

    public Module(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

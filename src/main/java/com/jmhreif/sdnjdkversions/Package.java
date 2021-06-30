package com.jmhreif.sdnjdkversions;

import org.springframework.data.neo4j.core.schema.Node;

@Node("Package")
public class Package extends Delta {

    public Package(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

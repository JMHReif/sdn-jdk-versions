package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.Node;

@Node("Annotation")
public class JavaAnnotation extends Delta {
    public JavaAnnotation(Long neoId, String name, String docURL, String status) {
        super(neoId, name, docURL, status);
    }
}

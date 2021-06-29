package com.jmhreif.sdnjdkversions;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class VersionDiff {
    @Id
    @GeneratedValue
    private final Long neoId;

    private String fromVendor;
    private String fromVersion;
    private String toVendor;
    private String toVersion;

    public VersionDiff(Long neoId, String fromVendor, String fromVersion, String toVendor, String toVersion) {
        this.neoId = neoId;
        this.fromVendor = fromVendor;
        this.fromVersion = fromVersion;
        this.toVendor = toVendor;
        this.toVersion = toVersion;
    }

    public Long getNeoId() {
        return neoId;
    }

    public String getFromVendor() {
        return fromVendor;
    }

    public void setFromVendor(String fromVendor) {
        this.fromVendor = fromVendor;
    }

    public String getFromVersion() {
        return fromVersion;
    }

    public void setFromVersion(String fromVersion) {
        this.fromVersion = fromVersion;
    }

    public String getToVendor() {
        return toVendor;
    }

    public void setToVendor(String toVendor) {
        this.toVendor = toVendor;
    }

    public String getToVersion() {
        return toVersion;
    }

    public void setToVersion(String toVersion) {
        this.toVersion = toVersion;
    }
}

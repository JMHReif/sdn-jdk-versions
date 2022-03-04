package com.jmhreif.sdnjdkversions.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class VersionDiff {
    @Id
    @GeneratedValue
    private final Long neoId;

    private String fromVendor;
    private String fromVersion;
    private String toVendor;
    private String toVersion;

    @Relationship("HAS_DELTA")
    private List<Delta> deltas;

    @Relationship(value = "FROM_OLDER",direction = Relationship.Direction.INCOMING)
    private JavaVersion olderJavaVersion;

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

    public String getFromVersion() {
        return fromVersion;
    }

    public String getToVendor() {
        return toVendor;
    }

    public String getToVersion() {
        return toVersion;
    }

    public List<Delta> getDeltas() {
        return deltas;
    }

    public JavaVersion getOlderJavaVersion() {
        return olderJavaVersion;
    }

    @Override
    public String toString() {
        return "VersionDiff{" +
                "neoId=" + neoId +
                ", fromVendor='" + fromVendor + '\'' +
                ", fromVersion='" + fromVersion + '\'' +
                ", toVendor='" + toVendor + '\'' +
                ", toVersion='" + toVersion + '\'' +
                ", deltas=" + deltas +
                ", olderJavaVersion=" + olderJavaVersion +
                '}';
    }
}

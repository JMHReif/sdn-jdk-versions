package com.jmhreif.sdnjdkversions.domain;

import java.util.List;

public interface JavaVersionProjection {

    String getJavaVersion();
    List<DiffProjection> getOlderVersionDiffs();

    interface DiffProjection {
        String getFromVersion();
    }
}

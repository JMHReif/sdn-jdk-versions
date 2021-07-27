package com.jmhreif.sdnjdkversions.domain;

import java.util.List;
import java.util.stream.Collectors;

public interface JavaVersionProjection {

    String getJavaVersion();
    List<DiffProjection> getOlderVersionDiffs();

    interface DiffProjection {
        String getFromVersion();
    }
}

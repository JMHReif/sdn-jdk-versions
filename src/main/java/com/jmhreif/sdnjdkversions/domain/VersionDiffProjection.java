package com.jmhreif.sdnjdkversions.domain;

import java.util.List;

public interface VersionDiffProjection {
    String getFromVersion();
    String getToVersion();
    List<ModuleProjection> getModuleName();
    List<PackageProjection> getPackageName();

    interface ModuleProjection {
        String getName();
    }

    interface PackageProjection {
        String getName();
    }
}

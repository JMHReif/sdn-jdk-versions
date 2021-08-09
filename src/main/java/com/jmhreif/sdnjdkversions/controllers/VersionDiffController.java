package com.jmhreif.sdnjdkversions.controllers;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import com.jmhreif.sdnjdkversions.domain.VersionDiffProjection;
import com.jmhreif.sdnjdkversions.repositories.VersionDiffRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diffs")
public class VersionDiffController {
    private final VersionDiffRepo versionDiffRepo;

    public VersionDiffController(VersionDiffRepo versionDiffRepo) {
        this.versionDiffRepo = versionDiffRepo;
    }

    @GetMapping()
    public Iterable<VersionDiffProjection> findAllVersionDiffs() { return versionDiffRepo.findVersionDiffs(); }

    @GetMapping("/version")
    public Iterable<VersionDiff> findDiffsFromVersion(@RequestParam String version) { return versionDiffRepo.findVersionDiffsBy(version); }

    @GetMapping("/between")
    public VersionDiff findDiffBetween(@RequestParam String newer, @RequestParam String older) { return versionDiffRepo.findVersionDiffBetween(newer, older); }
}

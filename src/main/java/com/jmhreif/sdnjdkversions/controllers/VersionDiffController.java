package com.jmhreif.sdnjdkversions.controllers;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import com.jmhreif.sdnjdkversions.repositories.VersionDiffRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diffs")
public class VersionDiffController {
    private final VersionDiffRepo versionDiffRepo;

    public VersionDiffController(VersionDiffRepo versionDiffRepo) {
        this.versionDiffRepo = versionDiffRepo;
    }

    @GetMapping
    public Iterable<VersionDiff> findAllDiffs() { return versionDiffRepo.findAll(); }
}

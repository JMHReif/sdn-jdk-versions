package com.jmhreif.sdnjdkversions.controllers;

import com.jmhreif.sdnjdkversions.domain.JavaVersion;
import com.jmhreif.sdnjdkversions.repositories.JavaVersionRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versions")
public class JavaVersionController {
    private final JavaVersionRepo javaVersionRepo;

    public JavaVersionController(JavaVersionRepo javaVersionRepo) {
        this.javaVersionRepo = javaVersionRepo;
    }

    @GetMapping
    public Iterable<JavaVersion> findAllVersions() { return javaVersionRepo.findAll(); }

    @GetMapping("/diffs")
    Iterable<JavaVersion> findConnectedDiffs() { return javaVersionRepo.findConnectedDiffs(); }
}

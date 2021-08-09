package com.jmhreif.sdnjdkversions.controllers;

import com.jmhreif.sdnjdkversions.domain.JavaVersion;
import com.jmhreif.sdnjdkversions.domain.JavaVersionProjection;
import com.jmhreif.sdnjdkversions.repositories.JavaVersionRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/versions")
public class JavaVersionController {
    private final JavaVersionRepo javaVersionRepo;

    public JavaVersionController(JavaVersionRepo javaVersionRepo) {
        this.javaVersionRepo = javaVersionRepo;
    }

    @GetMapping
    public Iterable<JavaVersionProjection> findAllJavaVersionProjections() { return javaVersionRepo.findAllJavaVersionProjections(); }

    @GetMapping("/diffs")
    Iterable<JavaVersion> findConnectedDiffs() { return javaVersionRepo.findConnectedDiffs(); }

    @GetMapping("/{id}")
    Optional<JavaVersion> findById(@PathVariable("id") String id) { return javaVersionRepo.findById(id); }
}

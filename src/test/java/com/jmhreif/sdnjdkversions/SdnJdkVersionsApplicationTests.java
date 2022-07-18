package com.jmhreif.sdnjdkversions;

import com.jmhreif.sdnjdkversions.domain.VersionDiff;
import com.jmhreif.sdnjdkversions.repositories.VersionDiffRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SdnJdkVersionsApplicationTests {
	private final VersionDiffRepo repo;

	@Autowired
	SdnJdkVersionsApplicationTests(VersionDiffRepo repo) {
		this.repo = repo;
	}

	@Test
	void findDiffsForVersion() {
		var versionDiffsBy = repo.findVersionDiffsBy("17");
		System.out.println(versionDiffsBy.size());
	}

	@Test
	void findDiffForBetweenTwoVersions() {
		var versionDiffsBy = repo.findVersionDiffBetween("17", "11");
		System.out.println(versionDiffsBy);
	}

}

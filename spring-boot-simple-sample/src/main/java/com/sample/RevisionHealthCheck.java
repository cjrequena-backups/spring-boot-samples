package com.sample;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.jcabi.manifests.Manifests;

@Component
public class RevisionHealthCheck implements HealthIndicator {
	private static final String BUILD_NUMBER = "Build-Number";

	@Override
	public Health health() {
		Health.Builder builder = new Health.Builder();
		String release = "";
		if (Manifests.exists(BUILD_NUMBER)) {
			release = Manifests.read(BUILD_NUMBER);
		}
		builder = Health.up().withDetail("Revision", release);
		return builder.build();
	}
}

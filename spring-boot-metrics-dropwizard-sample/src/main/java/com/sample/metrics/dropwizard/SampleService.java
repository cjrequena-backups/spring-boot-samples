
package com.sample.metrics.dropwizard;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class SampleService {

	private String name = "World";

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHelloMessage() {
		return "Hello " + this.name;
	}

}
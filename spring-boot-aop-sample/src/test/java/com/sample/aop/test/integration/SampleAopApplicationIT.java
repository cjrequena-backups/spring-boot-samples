package com.sample.aop.test.integration;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import com.sample.aop.AopApplication;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SampleAopApplicationIT {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (profiles != null) {
			log.info("spring.profiles.active", profiles);
		} else {
			log.info("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		AopApplication.main(new String[0]);
		String output = outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Monitored Method"));
	}

}
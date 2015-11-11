package com.sample.aop;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

/**
 * Tests for {@link MainApplication}.
 *
 * @author Dave Syer
 * @author Phillip Webb
 */
public class SampleAopApplicationTests {

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
			System.setProperty("spring.profiles.active", profiles);
		} else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		MainApplication.main(new String[0]);
		String output = outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Hello Carlos"));
	}

}

package com.sample.metrics.dropwizard;

import java.util.Collections;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Description("A controller for handling requests for hello messages")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@Autowired
	private GaugeService gauges;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> hello() {
		this.gauges.submit("test.metrics.dropwizard.crequena", Math.random() * 1000 + 1000);
		return Collections.singletonMap("message", this.sampleService.getHelloMessage());
	}

	protected static class Message {

		@NotBlank(message = "Message value cannot be empty")
		private String value;

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}
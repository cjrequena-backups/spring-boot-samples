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

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

@Controller
@Description("A controller for handling requests for hello messages")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@Autowired
	private GaugeService gauges;

	@Autowired
	private MetricRegistry registry;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> hello() {

		// A counter is a simple incrementing and decrementing 64-bit integer:
		Counter pendingJobs = registry.counter(MetricRegistry.name(SampleController.class, "PROJECT_NAME", "counter"));

		// A Histogram measures the distribution of values in a stream of data:
		// e.g., the number of results returned by a search:
		Histogram histogram = registry.histogram(MetricRegistry.name(SampleController.class, "PROJECT_NAME", "histogram"));

		// A meter measures the rate of events over time (e.g., “requests per
		// second”). In addition to the mean rate, meters also track 1-, 5-, and
		// 15-minute moving averages.
		Meter meter = registry.meter(MetricRegistry.name(SampleController.class, "PROJECT_NAME", "meter"));

		// A timer is basically a histogram of the duration of a type of event
		// and a meter of the rate of its occurrence.
		final Timer responses = registry.timer(MetricRegistry.name(SampleController.class, "PROJECT_NAME", "timer"));

		pendingJobs.inc();
		histogram.update(20000);
		meter.mark();
		Timer.Context context = responses.time();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.stop();

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
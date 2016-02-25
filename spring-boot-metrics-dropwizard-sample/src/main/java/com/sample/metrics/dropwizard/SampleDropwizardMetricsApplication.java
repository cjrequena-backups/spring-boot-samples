
package com.sample.metrics.dropwizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

@SpringBootApplication
public class SampleDropwizardMetricsApplication {

	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleDropwizardMetricsApplication.class, args);
	}
}
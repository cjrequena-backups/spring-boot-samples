package com.sample.metrics.dropwizard.configuration;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.coursera.metrics.datadog.DatadogReporter;
import org.coursera.metrics.datadog.DatadogReporter.Expansion;
import org.coursera.metrics.datadog.transport.HttpTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Configuration
@ConfigurationProperties("datadog.metrics")
public class DatadogConfiguration {

	/** Datadog API key used to authenticate every request to Datadog API */
	private String apiKey;

	/** Logical name associated to all the events send by this application */
	private String host;

	/** Time, in seconds, between every call to Datadog API. The lower this value the more information will be send to Datadog */
	private long period;

	/** This flag enables or disables the datadog reporter */
	private boolean enabled = false;

	/**/
	List<String> tags;
	
	@Autowired
	private MetricRegistry registry;

	@Bean
	public JmxReporter jmxReporter() {
		JmxReporter reporter = JmxReporter.forRegistry(registry).build();
		reporter.start();
		return reporter;
	}

	@Bean
	@ExportMetricWriter
	MetricWriter metricWriter(MBeanExporter exporter) {
		return new JmxMetricWriter(exporter);
	}
	
	@Bean
	@Autowired
	public DatadogReporter datadogReporter(MetricRegistry registry) {

		DatadogReporter reporter = null;
		if (enabled) {
			reporter = enableDatadogMetrics(registry);
		} else {
			if (log.isWarnEnabled()) {
				log.info("Datadog reporter is disabled. To turn on this feature just set 'rJavaServer.metrics.enabled:true' in your config file (property or YAML)");
			}
		}

		return reporter;
	}

	private DatadogReporter enableDatadogMetrics(MetricRegistry registry) {

		if (log.isInfoEnabled()) {
			log.info("Initializing Datadog reporter using [ host: {}, period(seconds):{}, api-key:{} ]", getHost(), getPeriod(), getApiKey());
		}

		EnumSet<Expansion> expansions = DatadogReporter.Expansion.ALL;
		HttpTransport httpTransport = new HttpTransport.Builder().withApiKey(getApiKey()).build();

		DatadogReporter reporter = DatadogReporter.forRegistry(registry).withHost(getHost()).withTransport(httpTransport).withExpansions(expansions).withTags(tags).build();

		reporter.start(getPeriod(), TimeUnit.SECONDS);

		if (log.isInfoEnabled()) {
			log.info("Datadog reporter successfully initialized");
		}

		return reporter;
	}

	
}
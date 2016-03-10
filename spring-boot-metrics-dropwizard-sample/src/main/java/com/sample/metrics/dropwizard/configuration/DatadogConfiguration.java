package com.sample.metrics.dropwizard.configuration;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import org.coursera.metrics.datadog.DatadogReporter;
import org.coursera.metrics.datadog.DatadogReporter.Expansion;
import org.coursera.metrics.datadog.transport.HttpTransport;
import org.coursera.metrics.datadog.transport.Transport;
import org.coursera.metrics.datadog.transport.UdpTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.util.StringUtils;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("metrics.datadog")
public class DatadogConfiguration {

	// Required
	/** This flag enables or disables the datadog reporter */
	private boolean enabled = false;
	public  String transport;
	public  Long period;

	// HTTP Transport
	public  String apiKey;
	public  Integer connectTimeout;
	public  Integer socketTimeout;

	// UDP Transport
	public  String statsdHost;
	public  Integer statsdPort;
	public  String statsdPrefix;

	// Optional
	public  String host;
	public  Boolean ec2Host;
	public  String tags;
	public  String prefix;
	
	@Autowired
	private MetricRegistry metricRegistry;

	@Bean
	public JmxReporter jmxReporter() {
		JmxReporter reporter = JmxReporter.forRegistry(metricRegistry).build();
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
	protected DatadogReporter createInstance() {
		DatadogReporter.Builder reporter = DatadogReporter.forRegistry(metricRegistry);

		 Transport transportObj;
		if ("http".equalsIgnoreCase(transport)) {
			HttpTransport.Builder builder = new HttpTransport.Builder();
			builder.withApiKey(apiKey);
			if (connectTimeout != null) {
				builder.withConnectTimeout(connectTimeout);
			}
			if (socketTimeout != null) {
				builder.withSocketTimeout(socketTimeout);
			}
			transportObj = builder.build();
		} else if ("udp".equalsIgnoreCase(transport) || "statsd".equalsIgnoreCase(transport)) {
			UdpTransport.Builder builder = new UdpTransport.Builder();
			if (StringUtils.hasText(statsdHost)) {
				builder.withStatsdHost(statsdHost);
			}
			if (statsdPort != null) {
				builder.withPort(statsdPort);
			}
			if (StringUtils.hasText(statsdPrefix)) {
				builder.withPrefix(statsdPrefix);
			}
			transportObj = builder.build();
		} else {
			throw new IllegalArgumentException("Invalid Datadog Transport: " + transport);
		}
		reporter.withTransport(transportObj);

		if (StringUtils.hasText(tags)) {
			reporter.withTags(asList(StringUtils.tokenizeToStringArray(tags, ",", true, true)));
		}

		if (StringUtils.hasText(host)) {
			reporter.withHost(host);
		} else if (Boolean.TRUE==ec2Host) {
			try {
				reporter.withEC2Host();
			} catch (IOException e) {
				throw new IllegalStateException("DatadogReporter.Builder.withEC2Host threw an exception", e);
			}
		}

		if (StringUtils.hasText(prefix)) {
			reporter.withPrefix(prefix);
		}
		
		EnumSet<Expansion> expansions = DatadogReporter.Expansion.ALL;
		reporter.withExpansions(expansions);
		reporter.convertDurationsTo(TimeUnit.SECONDS);
		reporter.convertRatesTo(TimeUnit.HOURS);
		reporter.filter(MetricFilter.ALL);
		DatadogReporter datadogReporter = reporter.build();
		datadogReporter.start(period, TimeUnit.SECONDS);
		return datadogReporter;
	}

}
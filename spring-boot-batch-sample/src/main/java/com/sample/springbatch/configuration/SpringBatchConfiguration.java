package com.sample.springbatch.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by cjrequena on 11/08/16.
 */
@Configuration
@EnableBatchProcessing
@ImportResource("classpath*:/jobs/demo0.xml")
public class SpringBatchConfiguration {
}

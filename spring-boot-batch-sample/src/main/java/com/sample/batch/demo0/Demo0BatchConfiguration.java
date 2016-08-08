package com.sample.batch.demo0;

import com.sample.batch.JobCompletionNotificationListener;
import com.sample.batch.Person;
import com.sample.batch.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class Demo0BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    PrintHelloTasklet printHelloTasklet;

    @Autowired
    PrintWorldTasklet printWorldTasklet;

    @Bean
    public Job printHelloWorldJob(@Qualifier("step1") Step step1, @Qualifier("step2") Step step2) {
        return jobBuilderFactory.get("printHelloWorldJob")
                .start(step1).next(step2).build();
    }

    // tag::jobstep[]
    @Bean
    protected Step step1() {
        return stepBuilderFactory.get("step2")
                .tasklet(printHelloTasklet)
                .build();
    }

    @Bean
    protected Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(printWorldTasklet)
                .build();
    }
    // end::jobstep[]
}

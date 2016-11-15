package com.sample.db.configuration;



import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;


@Data
@Configuration
public class DatabaseConfiguration {

	@Bean(name = "dataSource", destroyMethod = "")
	@ConfigurationProperties(prefix = "datasources.chinook")
	@Primary
	public DataSource dataSource() {
		return new HikariDataSource();
	}

}

package com.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

	@Primary
	@Bean(name = "dataSource", destroyMethod = "")
	public DataSource getDataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2) // DERBY OR H2 OR HSQL
				.addScript("sql/countries.sql").build();
	}
}
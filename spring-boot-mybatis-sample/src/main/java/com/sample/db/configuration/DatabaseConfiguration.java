package com.sample.db.configuration;



import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

/**
 * <p>
 * Need to configure the following for each DataSource:
 *
 * - jdbcUrl=jdbc:oracle:thin:@HOST:PORT/BDD driverClassName=oracle.jdbc.OracleDriver
 * - username=xxxxx
 * - password=xxxxx
 * - maximumPoolSize=5
 *
 * Refer to {@link https://github.com/brettwooldridge/HikariCP/wiki/Configuration}. for more information
 * <p>
 * @author
 * @version
 * @since JDK1.8
 * @see
 *
 */
@Data
@Configuration
public class DatabaseConfiguration {

	public static final String DATASOURCE_SAMPLE = "DATASOURCE_SAMPLE";


	@Bean(name = DATASOURCE_SAMPLE, destroyMethod = "")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource getDataSource() {
		return new HikariDataSource();
	}

}

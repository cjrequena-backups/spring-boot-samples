package com.sample.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zaxxer.hikari.HikariConfig;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableJpaRepositories(basePackages = { "com.sample.db.repository" })
class DataBaseConfiguration implements TransactionManagementConfigurer {

	@Value("${dataSource.dataSourceClassName}")
	private String dataSourceClassName;
	@Value("${dataSource.driverClassName}")
	private String driverClassName;
	@Value("${dataSource.jdbcUrl}")
	private String jdbcUrl;
	@Value("${dataSource.username}")
	private String username;
	@Value("${dataSource.password}")
	private String password;
	@Value("${dataSource.maximumPoolSize}")
	private Integer maximumPoolSize;
	@Value("${dataSource.maxLifetimeMs}")
	private Integer maxLifetimeMs;
	@Value("${dataSource.idleTimeoutMs}")
	private Integer idleTimeoutMs;
	@Value("${dataSource.poolName}")
	private String poolName;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private Boolean showSql;
	@Value("${hibernate.format_sql}")
	private Boolean formatSql;
	
	@Value("${info.description}")
		private String xxx;

	@Bean
	@Primary
	public DataSource dataSource() {

		HikariConfig hikariConfig = new HikariConfig();
		// hc.setDataSourceClassName(dataSourceClassName);
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setJdbcUrl(jdbcUrl);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		hikariConfig.setPoolName(poolName);
		hikariConfig.addDataSourceProperty("databaseName", "chinook");
		hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.sample.db.entity");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties jpaProperties = new Properties();
		
		//Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
		jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
		
		//If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
		jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, showSql);
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		//If the value of this property is true, Hibernate will use prettyprint
        //when it writes SQL to the console.
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, formatSql);

		return entityManagerFactoryBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}
}

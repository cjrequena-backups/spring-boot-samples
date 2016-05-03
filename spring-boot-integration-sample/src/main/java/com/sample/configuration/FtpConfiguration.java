package com.sample.configuration;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;

@Configuration
public class FtpConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "ftp")
	public DefaultFtpSessionFactory ftpSessionFactory() {
		DefaultFtpSessionFactory ftpSessionFactory = new DefaultFtpSessionFactory();
		// ftpSessionFactory.setHost("localhost");
		// ftpSessionFactory.setPort(21);
		// ftpSessionFactory.setUsername("crequena");
		// ftpSessionFactory.setPassword("123456");
		System.out.println("message:2 ");
		ftpSessionFactory.setClientMode(FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE);
		return ftpSessionFactory;
	}
}

package com.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EhCacheApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(EhCacheApplication.class);
	}
}

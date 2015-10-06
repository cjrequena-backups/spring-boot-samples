package com.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SampleEhCacheMainApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(SampleEhCacheMainApp.class).profiles("app").run(args);
	}
}

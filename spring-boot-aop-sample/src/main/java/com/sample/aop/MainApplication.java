package com.sample.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.aop.service.HelloWorldService;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	// Simple example shows how an application can spy on itself with AOP

	@Autowired
	private HelloWorldService helloWorldService;

	@Override
	public void run(String... args) {
		System.out.println(helloWorldService.getHelloMessage());
		System.out.println(helloWorldService.getHelloMessageAnnotated());
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
	}
}

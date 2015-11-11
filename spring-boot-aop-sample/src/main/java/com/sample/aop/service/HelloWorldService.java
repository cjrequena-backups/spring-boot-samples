package com.sample.aop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sample.aop.annotation.Monitored;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getHelloMessage() {
		return "Hello " + name;
	}

	@Monitored
	public String getHelloMessageAnnotated() {
		return "Hello " + name;
	}

}
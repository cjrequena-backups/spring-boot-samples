package com.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {
	
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@RequestMapping("/")
	public String home() {
		return "Redis Host " + redisHost;
	}
}

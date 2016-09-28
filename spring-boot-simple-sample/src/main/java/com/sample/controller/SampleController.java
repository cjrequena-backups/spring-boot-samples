package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@Autowired
	private Tracer tracer;

	@Autowired
	private SpanAccessor accessor;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		log.debug("Hello World");
		return "Hello World!";
	}
}

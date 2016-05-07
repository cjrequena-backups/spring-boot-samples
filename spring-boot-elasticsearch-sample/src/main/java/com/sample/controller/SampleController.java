package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@RequestMapping("/")
	@ResponseBody
	String home() {
		log.debug("Hello World");
		return "Hello World!";
	}
}

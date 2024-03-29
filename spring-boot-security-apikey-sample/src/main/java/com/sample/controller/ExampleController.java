package com.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ExampleController {
	@RequestMapping("/")
	@ResponseBody
	String home() {
		log.debug("Hello World");
		return "Hello World!";
	}
}

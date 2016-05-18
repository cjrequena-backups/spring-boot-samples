package com.sample.controller;

import com.sample.db.elasticsearch.mapper.CountryESMapper;
import com.sample.db.elasticsearch.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SampleController {

	@Autowired
	CountryESMapper articleIndexer;
    @Autowired
	CountryRepository countryLoader;

	@RequestMapping("/")
	@ResponseBody
	String home() throws Exception{
		articleIndexer.map();
        countryLoader.loadDataToElasticSearch();
		log.debug("Hello World");
		return "Hello World!";
	}
}

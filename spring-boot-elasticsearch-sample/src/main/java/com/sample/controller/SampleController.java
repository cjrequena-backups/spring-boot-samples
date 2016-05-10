package com.sample.controller;

import com.sample.indexer.CountryIndexer;
import com.sample.loader.CountryLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SampleController {

	@Autowired
	CountryIndexer articleIndexer;
    @Autowired
    CountryLoader countryLoader;

	@RequestMapping("/")
	@ResponseBody
	String home() throws Exception{
		articleIndexer.index();
        countryLoader.loadDataToElasticSearch();
		log.debug("Hello World");
		return "Hello World!";
	}
}

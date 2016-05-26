package com.sample.controller;

import com.sample.db.elasticsearch.index.CountryIndex;
import com.sample.db.elasticsearch.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SampleController {

	@Autowired
	CountryIndex countryESMapper;
    @Autowired
	CountryRepository countryRepository;

	@RequestMapping("/deleteIndex")
	@ResponseBody
	String deleteIndex() throws Exception{
		countryESMapper.deleteIndex();
		return "Deleted";
	}

	@RequestMapping("/createIndex")
	@ResponseBody
	String createIndex() throws Exception{
		countryESMapper.createIndex();
		return "Created";
	}

	@RequestMapping("/mapIndex")
	@ResponseBody
	String mapIndex() throws Exception{
		countryESMapper.mapIndex();
		return "Mapped";
	}

	@RequestMapping("/loadCountries")
	@ResponseBody
	String loadCountriesToIndex() throws Exception{
		countryRepository.loadDataToElasticSearch();
		return "Hello World!";
	}

	@RequestMapping("/searchCountry/{country}")
	@ResponseBody
	String searchCountry(@PathVariable(value = "country") String country) throws Exception{
		countryRepository.findCountry(country, null, null, 10);
		return "Hello World!";
	}
}

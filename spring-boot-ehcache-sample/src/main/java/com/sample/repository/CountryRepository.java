package com.sample.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.sample.domain.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@CacheConfig(cacheNames = "countries")
public class CountryRepository {

	@Cacheable
	public Country findByCode(String code) {
		log.debug("---> Loading country with code '" + code + "'");
		return new Country(code);
	}

}

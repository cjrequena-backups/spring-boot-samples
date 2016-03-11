package com.sample.cache.test.integration;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.cache.Country;
import com.sample.cache.CountryRepository;
import com.sample.cache.CacheApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CacheApplication.class)
public class SampleCacheApplicationIT {
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void validateCache() {
		Cache countries = this.cacheManager.getCache("countries");
		assertThat(countries, is(notNullValue()));
		countries.clear(); // Simple test assuming the cache is empty
		assertThat(countries.get("BE"), is(nullValue()));
		Country be = this.countryRepository.findByCode("BE");
		assertThat((Country) countries.get("BE").get(), is(be));
		be = this.countryRepository.findByCode("BE");
		assertThat((Country) countries.get("BE").get(), is(be));
	}
}

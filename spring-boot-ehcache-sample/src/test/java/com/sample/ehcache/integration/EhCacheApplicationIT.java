/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.ehcache.integration;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.EhCacheApplication;
import com.sample.entity.CountryCacheEntity;
import com.sample.repository.ICacheRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EhCacheApplication.class)
public class EhCacheApplicationIT {

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	@Qualifier("countryRepository")
	private ICacheRepository<CountryCacheEntity> countryRepository;

	@Test
	public void validateCache() {

		Cache countries = this.cacheManager.getCache("countries");
		assertThat(countries, is(notNullValue()));
		countries.clear(); // Simple test assuming the cache is empty

		assertThat(countries.get("BE"), is(nullValue()));
		CountryCacheEntity be = new CountryCacheEntity("BE");
		this.countryRepository.put(be);
		assertThat((CountryCacheEntity) countries.get("BE").get(), is(be));

		CountryCacheEntity test = new CountryCacheEntity("TEST");
		this.countryRepository.put(test);
		assertThat((CountryCacheEntity) countries.get("TEST").get(), is(test));
		assertThat(this.countryRepository.get(be).equals((CountryCacheEntity) countries.get("BE").get()), is(true));
		
	}

}

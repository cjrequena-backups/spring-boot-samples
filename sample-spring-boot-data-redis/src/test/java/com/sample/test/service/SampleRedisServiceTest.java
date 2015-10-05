package com.sample.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sample.SampleRedisMainApp;
import com.sample.configurattion.Constants;
import com.sample.domain.SampleDomain;
import com.sample.service.ICacheService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleRedisMainApp.class)
@ActiveProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class SampleRedisServiceTest {

	private SampleDomain domain;

	@Autowired
	ICacheService<SampleDomain> cacheService;

	@Before
	public void setUp() throws Exception {
		domain = new SampleDomain("1", "DOMAIN_1");
	}

	@Test
	public void testfindAll() {
		cacheService.getAll();
		// assertThat(cacheService.findAll()).hasSize(totalDomains);
	}

	@Test
	public void testSave() {
		cacheService.put(domain);
	}

	@Test
	public void testFind() {
		cacheService.get(domain);
	}

	@Test
	public void testDelete() {
		cacheService.delete(domain);
		// assertThat(cacheService.findAll()).hasSize(totalDomains - 1);
	}

}

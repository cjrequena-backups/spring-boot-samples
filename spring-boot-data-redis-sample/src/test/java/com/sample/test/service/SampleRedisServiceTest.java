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
import com.sample.domain.SampleRedisDomain;
import com.sample.repository.IRedisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleRedisMainApp.class)
@ActiveProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class SampleRedisServiceTest {

	private SampleRedisDomain domain;

	@Autowired
	IRedisRepository<SampleRedisDomain> sampleRedisRepository;

	@Before
	public void setUp() throws Exception {
		domain = new SampleRedisDomain("1", "DOMAIN_1");
	}

	@Test
	public void testfindAll() {
		sampleRedisRepository.getAll();
		// assertThat(sampleRedisRepository.findAll()).hasSize(totalDomains);
	}

	@Test
	public void testSave() {
		sampleRedisRepository.put(domain);
	}

	@Test
	public void testFind() {
		sampleRedisRepository.get(domain);
	}

	@Test
	public void testDelete() {
		sampleRedisRepository.delete(domain);
		// assertThat(sampleRedisRepository.findAll()).hasSize(totalDomains - 1);
	}

}

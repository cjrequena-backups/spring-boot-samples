package com.sample.redis.test.integration;

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

import com.sample.RedisApplication;
import com.sample.entity.SampleRedisEntity;
import com.sample.repository.IRedisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedisApplication.class)
@ActiveProfiles("dev")
@WebAppConfiguration
@IntegrationTest
@Transactional
public class RedisApplicationIT {

	private SampleRedisEntity domain;

	@Autowired
	IRedisRepository<SampleRedisEntity> sampleRedisRepository;

	@Before
	public void setUp() throws Exception {
		domain = new SampleRedisEntity("1", "DOMAIN_1");
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

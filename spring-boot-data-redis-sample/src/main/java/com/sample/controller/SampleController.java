package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.SampleRedisEntity;
import com.sample.repository.IRedisRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Autowired
	IRedisRepository<SampleRedisEntity> sampleRedisRepository;

	@RequestMapping("/")
	public String home() {

		SampleRedisEntity domain = new SampleRedisEntity();
		domain.setId("KEY-1");
		domain.setName("BOOK ONE");
		sampleRedisRepository.put(domain);

		domain = sampleRedisRepository.get(domain);
		log.debug(domain.getId());
		log.debug(domain.getName());

		domain.setName("BOOK UPDATE");
		sampleRedisRepository.put(domain);

		domain = sampleRedisRepository.get(domain);
		log.debug(domain.getId());
		log.debug(domain.getName());

		return "Redis Host " + redisHost;
	}
}

package com.sample.repository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sample.annotation.CacheName;
import com.sample.entity.SampleRedisEntity;

import lombok.Data;

@Data
@Component
public class SampleRedisRepository implements IRedisRepository<SampleRedisEntity> {

	@Autowired
	private RedisTemplate<String, SampleRedisEntity> redisTemplate;

	@Override
	public void put(SampleRedisEntity domain) {
		redisTemplate.opsForHash().put(domain.getCacheName(), domain.getKey(), domain);
	}

	@Override
	public SampleRedisEntity get(SampleRedisEntity domain) {
		return (SampleRedisEntity) redisTemplate.opsForHash().get(domain.getCacheName(), domain.getKey());
	}

	@Override
	public void delete(SampleRedisEntity domain) {
		redisTemplate.opsForHash().delete(domain.getCacheName(), domain.getKey());
	}

	@Override
	public List<SampleRedisEntity> getAll() {
		Annotation annotation = SampleRedisEntity.class.getAnnotation(CacheName.class);
		CacheName cacheName = (CacheName) annotation;
		List<SampleRedisEntity> domains = new ArrayList<SampleRedisEntity>();
		for (Object domain : redisTemplate.opsForHash().values(cacheName.value())) {
			domains.add((SampleRedisEntity) domain);
		}
		return domains;
	}

	@Override
	public void deleteAll() {
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			SampleRedisEntity domain = new SampleRedisEntity(it.next());
			delete(domain);
		}
	}

}

package com.sample.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sample.domain.SampleDomain;

import lombok.Data;

@Data
@Service
public class SampleCacheService implements ICacheService<SampleDomain> {

	@Autowired
	private RedisTemplate<String, SampleDomain> redisTemplate;

	@Override
	public void put(SampleDomain domain) {
		redisTemplate.opsForHash().put(domain.getObjectKey(), domain.getKey(), domain);
	}

	@Override
	public SampleDomain get(SampleDomain domain) {
		return (SampleDomain) redisTemplate.opsForHash().get(domain.getObjectKey(), domain.getKey());
	}

	@Override
	public void delete(SampleDomain domain) {
		redisTemplate.opsForHash().delete(domain.getObjectKey(), domain.getKey());
	}

	@Override
	public List<SampleDomain> getAll() {
		List<SampleDomain> domains = new ArrayList<SampleDomain>();
		for (Object domain : redisTemplate.opsForHash().values(SampleDomain.OBJECT_KEY)) {
			domains.add((SampleDomain) domain);
		}
		return domains;
	}

	@Override
	public void deleteAll() {
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			SampleDomain domain = new SampleDomain(it.next());
			delete(domain);
		}
	}

}

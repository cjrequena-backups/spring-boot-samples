package com.sample.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sample.domain.SampleRedisDomain;

import lombok.Data;

@Data
@Component
public class SampleRedisRepository implements IRedisRepository<SampleRedisDomain> {

	@Autowired
	private RedisTemplate<String, SampleRedisDomain> redisTemplate;

	@Override
	public void put(SampleRedisDomain domain) {
		redisTemplate.opsForHash().put(domain.getObjectKey(), domain.getKey(), domain);
	}

	@Override
	public SampleRedisDomain get(SampleRedisDomain domain) {
		return (SampleRedisDomain) redisTemplate.opsForHash().get(domain.getObjectKey(), domain.getKey());
	}

	@Override
	public void delete(SampleRedisDomain domain) {
		redisTemplate.opsForHash().delete(domain.getObjectKey(), domain.getKey());
	}

	@Override
	public List<SampleRedisDomain> getAll() {
		List<SampleRedisDomain> domains = new ArrayList<SampleRedisDomain>();
		for (Object domain : redisTemplate.opsForHash().values(SampleRedisDomain.OBJECT_KEY)) {
			domains.add((SampleRedisDomain) domain);
		}
		return domains;
	}

	@Override
	public void deleteAll() {
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			SampleRedisDomain domain = new SampleRedisDomain(it.next());
			delete(domain);
		}
	}

}

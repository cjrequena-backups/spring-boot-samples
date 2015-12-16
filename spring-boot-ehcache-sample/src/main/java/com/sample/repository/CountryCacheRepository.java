package com.sample.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.annotation.CacheName;
import com.sample.entity.CountryCacheEntity;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;


@Component("countryRepository")
@CacheName("countries")
public class CountryCacheRepository extends CacheRepository<CountryCacheEntity> implements ICacheRepository<CountryCacheEntity> {

	@Autowired
	private net.sf.ehcache.CacheManager ehCacheManager;

	@Override
	public void put(CountryCacheEntity entity) {
		Cache cache = ehCacheManager.getCache(cacheName());
		cache.put(new Element(entity.getKey(), entity));
	}

	@Override
	public CountryCacheEntity get(CountryCacheEntity entity) {
		Cache cache = ehCacheManager.getCache(cacheName());
		Element element = cache.get(entity.getKey());
		entity = (CountryCacheEntity) element.getObjectValue();
		return entity;
	}

	@Override
	public List<CountryCacheEntity> getAll() {
		List<CountryCacheEntity> list = new ArrayList<>();
		Cache cache = ehCacheManager.getCache(cacheName());
		for (Object key : cache.getKeys()) {
			Element element = cache.get(key);
			if (element != null && element.getObjectValue() != null) {
				CountryCacheEntity entity = (CountryCacheEntity) element.getObjectValue();
				list.add(entity);
			}
		}
		return list;
	}

	@Override
	public void delete(CountryCacheEntity entity) {
		Cache cache = ehCacheManager.getCache(cacheName());
		cache.remove(entity.getKey());
	}

	@Override
	public void deleteAll() {
		Cache cache = ehCacheManager.getCache(cacheName());
		for (Object key : cache.getKeys()) {
			Element element = cache.get(key);
			if (element != null && element.getObjectValue() != null) {
				CountryCacheEntity entity = (CountryCacheEntity) element.getObjectValue();
				cache.remove(entity.getKey());
			}
		}
	}

}

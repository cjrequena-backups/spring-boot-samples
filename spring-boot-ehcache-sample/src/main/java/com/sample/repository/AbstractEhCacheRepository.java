package com.sample.repository;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.cache.CacheName;
import com.sample.cache.Cacheable;

import lombok.Data;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 *
 * @author crequena
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
@Data
@Component
public abstract class AbstractEhCacheRepository<T extends Cacheable> implements CacheRepository<T> {

	@Autowired
	private CacheManager ehCacheManager;
	private Cache cache;
	private String cacheName;

	protected AbstractEhCacheRepository(Class<T> targetClass) {
		if (targetClass == null) {
			throw new IllegalArgumentException("<Null>");
		}

		Annotation annotation = targetClass.getAnnotation(CacheName.class);
		cacheName = ((CacheName) annotation).value();
	}

	@PostConstruct
	public final void postConstruct() {
		cache = ehCacheManager.getCache(cacheName);
	}

	@Override
	public void put(T entity) {
		cache.put(new Element(entity.getObjectKey(), entity));
	}

	@Override
	public T get(T entity) {
		Element element = cache.get(entity.getObjectKey());
		entity = (T) element.getObjectValue();
		return entity;
	}

	@Override
	public List<T> getAll() {
		List<T> list = new ArrayList<>();
		for (Object key : cache.getKeys()) {
			Element element = cache.get(key);
			if (element != null && element.getObjectValue() != null) {
				T entity = (T) element.getObjectValue();
				list.add(entity);
			}
		}
		return list;
	}

	@Override
	public void delete(T entity) {
		cache.remove(entity.getObjectKey());
	}

	@Override
	public void deleteAll() {
		for (Object key : cache.getKeys()) {
			Element element = cache.get(key);
			if (element != null && element.getObjectValue() != null) {
				T entity = (T) element.getObjectValue();
				cache.remove(entity.getObjectKey());
			}
		}
	}
}

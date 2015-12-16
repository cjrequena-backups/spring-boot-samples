package com.sample.repository;

import java.lang.annotation.Annotation;

import com.sample.annotation.CacheName;

public abstract class CacheRepository<T> implements ICacheRepository<T> {

	@Override
	public String cacheName() {
		Annotation annotation = super.getClass().getAnnotation(CacheName.class);
		CacheName cacheName = (CacheName) annotation;
		return cacheName.value();
	}

}

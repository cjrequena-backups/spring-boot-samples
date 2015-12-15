package com.sample.entity;

import java.lang.annotation.Annotation;

import com.sample.annotation.CacheName;

import lombok.Data;

@Data
@CacheName(value = "SAMPLE_CACHE")
public class SampleRedisEntity implements Cacheable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public static String CACHE_NAME;

	/**
	 *
	 */
	public SampleRedisEntity() {
	}

	public SampleRedisEntity(String id) {
		this.id = id;
	}

	public SampleRedisEntity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String id;

	private String name;

	@Override
	public String getKey() {
		return getId();
	}

	@Override
	public String getCacheName() {
		Annotation annotation = this.getClass().getAnnotation(CacheName.class);
		CacheName cacheName = (CacheName) annotation;
		return cacheName.value();
	}

}

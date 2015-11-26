package com.sample.domain;

import lombok.Data;

@Data
public class SampleRedisDomain implements Cacheable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public static final String CACHE_NAME = "SAMPLE_CACHE";
	/**
	 *
	 */
	public SampleRedisDomain() {
	}

	public SampleRedisDomain(String id) {
		this.id = id;
	}

	public SampleRedisDomain(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String id;

	private String name;

	@Override
	public String getObjectKey() {
		return getId();
	}

	@Override
	public String getCacheName() {
		return CACHE_NAME;
	}

}

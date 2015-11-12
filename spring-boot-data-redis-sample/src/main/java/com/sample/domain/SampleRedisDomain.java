package com.sample.domain;

import lombok.Data;

@Data
public class SampleRedisDomain implements Cacheable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String OBJECT_KEY = "SAMPLE_DOMAIN";

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
	public String getKey() {
		return getId();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

}

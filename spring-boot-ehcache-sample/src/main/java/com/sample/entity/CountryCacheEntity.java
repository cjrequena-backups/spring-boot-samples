package com.sample.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class CountryCacheEntity implements Cacheable, Serializable {

	private final String code;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CountryCacheEntity countryCacheEntity = (CountryCacheEntity) o;

		return this.code.equals(countryCacheEntity.code);
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public String getKey() {
		return getCode();
	}

}

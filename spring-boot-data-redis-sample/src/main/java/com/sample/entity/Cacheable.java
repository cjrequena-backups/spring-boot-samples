package com.sample.entity;

import java.io.Serializable;

public interface Cacheable extends Serializable {

	String getCacheName();
	String getKey();

}

package com.sample.domain;

import java.io.Serializable;

public interface Cacheable extends Serializable {
	
	String getKey();

	String getObjectKey();
}

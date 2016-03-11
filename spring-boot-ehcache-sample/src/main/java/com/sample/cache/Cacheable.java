package com.sample.cache;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * <p>
 * <p>
 *
 * @author
 * @version
 * @since JDK1.8
 * @see
 *
 */

public abstract class Cacheable implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private Object objectKey;

	public Object getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(Object objectKey) {
		this.objectKey = objectKey;
	}

	public String getCacheName() {
		Annotation annotation = super.getClass().getAnnotation(CacheName.class);
		CacheName cacheName = (CacheName) annotation;
		return cacheName.value();
	}

}

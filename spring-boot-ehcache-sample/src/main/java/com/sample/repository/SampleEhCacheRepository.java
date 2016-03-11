package com.sample.repository;

import org.springframework.stereotype.Component;

import com.sample.entity.SampleEntity;

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

@Component("sampleEhCacheRepository")
public class SampleEhCacheRepository extends AbstractEhCacheRepository<SampleEntity> implements CacheRepository<SampleEntity> {

	protected SampleEhCacheRepository() {
		super(SampleEntity.class);
	}

}

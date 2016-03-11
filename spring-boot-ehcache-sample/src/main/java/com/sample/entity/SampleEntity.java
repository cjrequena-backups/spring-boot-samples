package com.sample.entity;

import java.io.Serializable;

import com.sample.cache.CacheName;
import com.sample.cache.Cacheable;

import lombok.Data;

/**
 *
 * @author crequena
 *
 */
@Data
@CacheName("EH_CACHE")
public class SampleEntity extends Cacheable implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

}

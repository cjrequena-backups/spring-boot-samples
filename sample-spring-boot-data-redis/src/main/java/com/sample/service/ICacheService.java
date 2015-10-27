package com.sample.service;

import java.util.List;

import com.sample.domain.Cacheable;

public interface ICacheService<T extends Cacheable> {

	public void put(T domain);

	public T get(T domain);
	
	public List<T> getAll();

	public void delete(T domain);
	
	public void deleteAll();

}

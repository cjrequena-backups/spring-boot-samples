package com.sample.repository;

import java.util.List;

import com.sample.entity.CountryCacheEntity;

/**
 *
 * @author crequena
 *
 * @param <T>
 */
public interface ICacheRepository<T> {

	public void put(T entity);

	public T get(T entity);

	public List<T> getAll();

	public void delete(T entity);

	public void deleteAll();
	
	public String cacheName();

}

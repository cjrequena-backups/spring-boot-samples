package com.sample.repository;
import java.util.List;

import com.sample.cache.Cacheable;


/**
*
* @author crequena
*
* @param <T>
*/
public interface CacheRepository<T extends Cacheable> {

	public void put(T entity);

	public T get(T entity);

	public List<T> getAll();

	public void delete(T entity);

	public void deleteAll();

}

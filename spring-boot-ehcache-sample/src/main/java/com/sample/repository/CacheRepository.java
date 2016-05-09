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

	 void put(T entity);

	 T get(T entity);

	 List<T> getAll();

	 void delete(T entity);

	 void deleteAll();

}

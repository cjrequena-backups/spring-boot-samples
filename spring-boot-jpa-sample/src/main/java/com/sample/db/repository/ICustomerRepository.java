package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.CustomerEntity;


public interface ICustomerRepository extends CrudRepository<CustomerEntity, Integer> {
	
}

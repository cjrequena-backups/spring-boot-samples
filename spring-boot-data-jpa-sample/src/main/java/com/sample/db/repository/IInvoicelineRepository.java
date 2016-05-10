package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.InvoicelineEntity;


public interface IInvoicelineRepository extends CrudRepository<InvoicelineEntity, Integer> {
	
}

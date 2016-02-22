package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.MediatypeEntity;


public interface IMediatypeRepository extends CrudRepository<MediatypeEntity, Integer> {
	
}

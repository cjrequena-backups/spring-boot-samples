package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.GenreEntity;


public interface IGenreRepository extends CrudRepository<GenreEntity, Integer> {
	
}

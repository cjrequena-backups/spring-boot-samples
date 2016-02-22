package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.ArtistEntity;


public interface IArtistRepository extends CrudRepository<ArtistEntity, Integer> {
	
}

package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.TrackEntity;


public interface ITrackRepository extends CrudRepository<TrackEntity, Integer> {
	
}

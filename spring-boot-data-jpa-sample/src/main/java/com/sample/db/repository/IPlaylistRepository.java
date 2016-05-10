package com.sample.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.db.entity.PlaylistEntity;


public interface IPlaylistRepository extends CrudRepository<PlaylistEntity, Integer> {
	
}

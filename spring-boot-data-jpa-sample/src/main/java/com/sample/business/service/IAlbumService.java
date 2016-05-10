package com.sample.business.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sample.db.entity.AlbumEntity;

public interface IAlbumService {
	public long countAll() throws Exception;

	public void save(AlbumEntity object) throws Exception;

	public void update(AlbumEntity obj) throws Exception;

	public void delete(AlbumEntity obj) throws Exception;

	public void deleteByPk(Integer pk) throws Exception;

	public AlbumEntity findByPk(Integer pk) throws Exception;

	public List<AlbumEntity> findAll() throws Exception;

	public Page<AlbumEntity> findAll(Pageable pageable) throws Exception;

}

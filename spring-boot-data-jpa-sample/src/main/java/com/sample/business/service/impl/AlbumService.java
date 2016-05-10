package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.business.service.IAlbumService;
import com.sample.db.entity.AlbumEntity;
import com.sample.db.repository.AlbumRepository;

@Service("iAlbumService")
public class AlbumService implements IAlbumService, Serializable {

	@Autowired
	AlbumRepository albumRepository;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public long countAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(AlbumEntity object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AlbumEntity obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AlbumEntity obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public AlbumEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumEntity> findAll() throws Exception {
		return (List<AlbumEntity>) this.albumRepository.findAll();
	}

	@Override
	public Page<AlbumEntity> findAll(Pageable pageable) throws Exception {
		return this.albumRepository.findAll(pageable);
	}
}

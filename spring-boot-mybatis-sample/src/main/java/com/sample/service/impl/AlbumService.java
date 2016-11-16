package com.sample.service.impl;


import com.sample.db.mapper.AlbumMapper;
import com.sample.db.pojos.AlbumEntity;
import com.sample.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("iAlbumService")
public class AlbumService implements IAlbumService, Serializable {

	@Autowired
	AlbumMapper albumMapper;

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
	public void create(AlbumEntity entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AlbumEntity entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AlbumEntity entity) throws Exception {
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
		return this.albumMapper.selectAll();
	}
	
}

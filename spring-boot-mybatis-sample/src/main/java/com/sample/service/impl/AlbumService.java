package com.sample.service.impl;


import com.sample.db.mapper.AlbumMapper;
import com.sample.db.pojos.AlbumEntity;
import com.sample.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation= Propagation.REQUIRED, readOnly=true, rollbackFor=Exception.class)
	public long countAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void create(AlbumEntity entity) throws Exception {
		this.albumMapper.insert(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void update(AlbumEntity entity) throws Exception {
		this.albumMapper.updateByPrimaryKey(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void delete(AlbumEntity entity) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public void deleteByPk(Integer pk) throws Exception {
		this.albumMapper.deleteByPrimaryKey(pk);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, rollbackFor=Exception.class)
	public AlbumEntity findByPk(Integer pk) throws Exception {
		return this.albumMapper.selectByPrimaryKey(pk);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, rollbackFor=Exception.class)
	public List<AlbumEntity> findAll() throws Exception {
		return this.albumMapper.selectAll();
	}
	
}

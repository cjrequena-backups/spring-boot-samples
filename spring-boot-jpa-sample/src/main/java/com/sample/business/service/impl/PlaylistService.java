package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IPlaylistService;
import com.sample.db.entity.PlaylistEntity;

@Service
@Transactional
public class PlaylistService implements IPlaylistService, Serializable {

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
	public void save(PlaylistEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PlaylistEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PlaylistEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlaylistEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaylistEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaylistEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

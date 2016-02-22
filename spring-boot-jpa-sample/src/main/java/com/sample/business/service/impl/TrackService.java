package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.ITrackService;
import com.sample.db.entity.TrackEntity;

@Service
@Transactional
public class TrackService implements ITrackService, Serializable {

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
	public void save(TrackEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TrackEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TrackEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TrackEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrackEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrackEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}

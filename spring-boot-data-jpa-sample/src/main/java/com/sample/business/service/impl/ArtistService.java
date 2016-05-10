package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IArtistService;
import com.sample.db.entity.ArtistEntity;

@Service
@Transactional
public class ArtistService implements IArtistService, Serializable {

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
	public void save(ArtistEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArtistEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ArtistEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArtistEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtistEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtistEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IGenreService;
import com.sample.db.entity.GenreEntity;

@Service
@Transactional
public class GenreService implements IGenreService, Serializable {

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
	public void save(GenreEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GenreEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GenreEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenreEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenreEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenreEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

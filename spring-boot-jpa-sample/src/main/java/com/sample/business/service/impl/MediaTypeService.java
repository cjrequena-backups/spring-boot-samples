package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IMediatypeService;
import com.sample.db.entity.MediatypeEntity;

@Service
@Transactional
public class MediaTypeService implements IMediatypeService, Serializable {

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
	public void save(MediatypeEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MediatypeEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MediatypeEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MediatypeEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediatypeEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediatypeEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

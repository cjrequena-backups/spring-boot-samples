package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IEmployeeService;
import com.sample.db.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeService implements IEmployeeService, Serializable {

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
	public void save(EmployeeEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EmployeeEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.ICustomerService;
import com.sample.db.entity.CustomerEntity;

@Service
@Transactional
public class CustomerService implements ICustomerService, Serializable {

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
	public void save(CustomerEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CustomerEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CustomerEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

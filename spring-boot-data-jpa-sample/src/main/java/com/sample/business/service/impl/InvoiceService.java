package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IInvoiceService;
import com.sample.db.entity.InvoiceEntity;

@Service
@Transactional
public class InvoiceService implements IInvoiceService, Serializable {

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
	public void save(InvoiceEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(InvoiceEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InvoiceEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InvoiceEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

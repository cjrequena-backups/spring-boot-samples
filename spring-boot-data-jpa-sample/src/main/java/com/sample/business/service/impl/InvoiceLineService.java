package com.sample.business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.business.service.IInvoicelineService;
import com.sample.db.entity.InvoicelineEntity;

@Service
@Transactional
public class InvoiceLineService implements IInvoicelineService, Serializable {

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
	public void save(InvoicelineEntity object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(InvoicelineEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InvoicelineEntity obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InvoicelineEntity findByPk(Integer pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoicelineEntity> findEntries(int firstResult, int maxResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoicelineEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

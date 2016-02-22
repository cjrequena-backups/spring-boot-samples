package com.sample.business.service;

import java.util.List;

import com.sample.db.entity.EmployeeEntity;

public interface IEmployeeService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract long countAll() throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract void save(EmployeeEntity object) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract void update(EmployeeEntity obj) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract void delete(EmployeeEntity obj) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public void deleteByPk(Integer pk) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract EmployeeEntity findByPk(Integer pk) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public List<EmployeeEntity> findEntries(int firstResult, int maxResults) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract List<EmployeeEntity> findAll() throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	//public List<EmployeeEntity> executeQueryFilter(List<Filter> filters, int firstResult, int maxResult) throws Exception;
}

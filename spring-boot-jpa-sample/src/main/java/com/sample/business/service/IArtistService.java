package com.sample.business.service;

import java.util.List;

import com.sample.db.entity.ArtistEntity;

public interface IArtistService {
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
	public abstract void save(ArtistEntity object) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract void update(ArtistEntity obj) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract void delete(ArtistEntity obj) throws Exception;

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
	public abstract ArtistEntity findByPk(Integer pk) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public List<ArtistEntity> findEntries(int firstResult, int maxResults) throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	public abstract List<ArtistEntity> findAll() throws Exception;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 **/
	// public List<ArtistEntity> executeQueryFilter(List<Filter> filters, int firstResult, int maxResult) throws Exception;
}

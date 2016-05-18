package com.sample.db.mybatis.mapper;

import com.sample.db.entity.Country;

import java.util.List;

/**
 *
 * @author crequena
 *
 */
public interface CountryMapper {

	public List<Country> getAll();

}
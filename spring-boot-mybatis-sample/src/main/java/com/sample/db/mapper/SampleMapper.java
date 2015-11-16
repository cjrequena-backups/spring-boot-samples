package com.sample.db.mapper;

import java.util.List;

import com.sample.db.entity.SampleMyBatisEntity;
/**
 *
 * @author crequena
 *
 */
public interface SampleMapper {

	public List<SampleMyBatisEntity> getAll();

	public int insert(SampleMyBatisEntity sample);

	public int update(SampleMyBatisEntity sample);
}
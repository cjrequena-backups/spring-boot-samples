
package com.sample.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.sample.db.entity.AlbumEntity;
import com.sample.dto.AlbumDTO;

/**
 * <p>
 * Mapping between entity beans and dto beans.
 * <p>
 * @author crequena
 * @version 1.0
 * @since JDK1.8
 * @see
 */
@Component
public class AlbumMapper extends AbstractMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;

	/**
	 * Constructor.
	 */
	public AlbumMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'Entity' to 'DTO'
	 * 
	 * @param entity
	 */
	public AlbumDTO mapEntityToDTO(AlbumEntity entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		AlbumDTO dto = map(entity, AlbumDTO.class);

		return dto;
	}

	/**
	 * Mapping from 'DTO' to 'Entity'
	 * 
	 * @param dto
	 * @param entity
	 */
	public void mapDTOToEntity(AlbumDTO dto, AlbumEntity entity) {
		if (dto == null) {
			return;
		}

		// --- Generic mapping
		map(dto, entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

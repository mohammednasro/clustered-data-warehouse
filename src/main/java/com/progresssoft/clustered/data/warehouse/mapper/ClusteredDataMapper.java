package com.progresssoft.clustered.data.warehouse.mapper;

import org.mapstruct.Mapper;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

@Mapper(componentModel = "spring")
public interface ClusteredDataMapper {

	public ClusteredDataModel toEntity(ClusteredDataDTO dto);
	public ClusteredDataDTO toDTO(ClusteredDataModel entity);
 
}

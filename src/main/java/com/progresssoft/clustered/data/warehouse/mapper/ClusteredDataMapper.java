package com.progresssoft.clustered.data.warehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

@Mapper(componentModel = "spring")
public interface ClusteredDataMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "fromCurrency", target = "fromCurrency")
	@Mapping(source = "toCurrency", target = "toCurrency")
	@Mapping(source = "timestamp", target = "timestamp")
	@Mapping(source = "amount", target = "amount")
	public ClusteredDataModel toEntity(ClusteredDataDTO dto);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "fromCurrency", target = "fromCurrency")
	@Mapping(source = "toCurrency", target = "toCurrency")
	@Mapping(source = "timestamp", target = "timestamp")
	@Mapping(source = "amount", target = "amount")
	public ClusteredDataDTO toDTO(ClusteredDataModel entity);
 
}

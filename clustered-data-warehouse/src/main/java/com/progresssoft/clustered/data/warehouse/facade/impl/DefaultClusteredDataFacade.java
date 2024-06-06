package com.progresssoft.clustered.data.warehouse.facade.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.data.domain.Page;

import com.google.common.base.Preconditions;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;
import com.progresssoft.clustered.data.warehouse.dto.PageDTO;
import com.progresssoft.clustered.data.warehouse.facade.ClusteredDataFacade;
import com.progresssoft.clustered.data.warehouse.mapper.ClusteredDataMapper;
import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;
import com.progresssoft.clustered.data.warehouse.service.ClusteredDataService;


@Service(value = "clusteredDataFacade")
public class DefaultClusteredDataFacade implements ClusteredDataFacade {

	private static final String CLUSTERED_DATA_DTO_BE_NULL = "clusteredDataDTO cannot be null!";
	private static final String CLUSTERED_DATA_DTO_ID_BE_NULL = "Id cannot be null!";

	private static final String CLUSTERED_DATA_LIST_DTO_BE_NULL = "clusteredDataListDTO cannot be null or empty!";

	@Autowired
	@Qualifier("clusteredDataService")
	private ClusteredDataService clusteredDataService;

	@Autowired
	private ClusteredDataMapper clusteredDataMapper;

	@Override
	public ClusteredDataDTO add(ClusteredDataDTO clusteredDataDTO) {
		Preconditions.checkNotNull(clusteredDataDTO, CLUSTERED_DATA_DTO_BE_NULL);

		return clusteredDataMapper.toDTO(clusteredDataService.add(clusteredDataMapper.toEntity(clusteredDataDTO)));
	}

	@Override
	public void addAll(ClusteredDataListDTO clusteredDataListDTO) {
		Preconditions.checkArgument(
				clusteredDataListDTO != null && !CollectionUtils.isEmpty(clusteredDataListDTO.getList()),
				CLUSTERED_DATA_LIST_DTO_BE_NULL);

		Set<ClusteredDataModel> set = new HashSet<>();

		for (ClusteredDataDTO dto : clusteredDataListDTO.getList()) {
			set.add(clusteredDataMapper.toEntity(dto));
		}

		clusteredDataService.addAll(set);
	}

	@Override
	public PageDTO<ClusteredDataDTO> findAll(Pageable pageable) {
		Page<ClusteredDataModel> all = clusteredDataService.findAll(pageable);
		
		
		List<ClusteredDataDTO> list=new ArrayList<>();
		for (ClusteredDataModel model : all.toList()) {
			list.add(clusteredDataMapper.toDTO(model));
		}
		
		return new PageDTO<ClusteredDataDTO>(list,all.getNumber(),all.getSize(),all.getTotalElements(),all.getTotalPages());
	}

	@Override
	public ClusteredDataDTO findById(Integer id) {
		Preconditions.checkNotNull(id, CLUSTERED_DATA_DTO_ID_BE_NULL);
		
		return clusteredDataMapper.toDTO( clusteredDataService.findById(id));
	}
}

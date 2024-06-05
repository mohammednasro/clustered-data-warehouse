package com.progresssoft.clustered.data.warehouse.facade;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;

public interface ClusteredDataFacade {
	public void add(ClusteredDataDTO clusteredDataModel);

	public void addAll(ClusteredDataListDTO clusteredDataListDTO);

}

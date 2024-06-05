package com.progresssoft.clustered.data.warehouse.facade;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;

/**
 *  @author mohammed.t.nasro@gmail.com
 *  
 * The Interface ClusteredDataFacade.
 */
public interface ClusteredDataFacade {
	
	/**
	 * Adds the.
	 *
	 * @param clusteredDataModel the clustered data model
	 */
	public void add(ClusteredDataDTO clusteredDataModel);

	/**
	 * Adds the all.
	 *
	 * @param clusteredDataListDTO the clustered data list DTO
	 */
	public void addAll(ClusteredDataListDTO clusteredDataListDTO);

}

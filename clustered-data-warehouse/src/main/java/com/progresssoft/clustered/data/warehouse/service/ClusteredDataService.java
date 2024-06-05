package com.progresssoft.clustered.data.warehouse.service;

import java.util.Set;

import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

/**
 * @author mohammed.t.nasro@gmail.com
 * 
 * The Interface ClusteredDataService.
 */
public interface ClusteredDataService {	
	
	/**
	 * Add the ClusteredData.
	 *
	 * @param clusteredDataModel the clustered data model
	 */
	public void add(ClusteredDataModel clusteredDataModel);
    
    /**
     * Add set of ClusteredDatas.
     *
     * @param list the list
     */
    public void addAll(Set<ClusteredDataModel> list);
}

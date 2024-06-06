package com.progresssoft.clustered.data.warehouse.service;

import java.util.Set;

import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClusteredDataService.
 *
 * @author mohammed.t.nasro@gmail.com
 * 
 * The Interface ClusteredDataService.
 */
public interface ClusteredDataService {	
	

	/**
	 * Adds the.
	 *
	 * @param clusteredDataModel the clustered data model
	 * @return the clustered data model
	 */
	public ClusteredDataModel add(ClusteredDataModel clusteredDataModel);
   
    /**
     * Adds the all.
     *
     * @param list the list
     */
    public void addAll(Set<ClusteredDataModel> list);
    
    /**
     * Find all.
     *
     * @param pageable the pageable
     * @return the page
     */
    public Page<ClusteredDataModel> findAll(Pageable pageable);
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the clustered data model
     */
    public ClusteredDataModel findById(Integer id);

}

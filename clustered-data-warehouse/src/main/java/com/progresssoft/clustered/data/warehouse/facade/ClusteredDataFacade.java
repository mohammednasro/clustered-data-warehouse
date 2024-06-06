package com.progresssoft.clustered.data.warehouse.facade;

import org.springframework.data.domain.Pageable;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;
import com.progresssoft.clustered.data.warehouse.dto.PageDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClusteredDataFacade.
 *
 * @author mohammed.t.nasro@gmail.com
 *  
 * The Interface ClusteredDataFacade.
 */
public interface ClusteredDataFacade {

	/**
	 * Adds the.
	 *
	 * @param clusteredDataDTO the clustered data DTO
	 * @return the clustered data DTO
	 */
	public ClusteredDataDTO add(ClusteredDataDTO clusteredDataDTO);

	/**
	 * Adds the all.
	 *
	 * @param clusteredDataListDTO the clustered data list DTO
	 */
	public void addAll(ClusteredDataListDTO clusteredDataListDTO);
	
    /**
     * Find all.
     *
     * @param pageable the pageable
     * @return the page DTO
     */
    public PageDTO<ClusteredDataDTO> findAll(Pageable pageable);
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the clustered data DTO
     */
    public ClusteredDataDTO findById(Integer id);


}

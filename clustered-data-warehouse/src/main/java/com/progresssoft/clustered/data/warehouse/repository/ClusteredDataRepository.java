package com.progresssoft.clustered.data.warehouse.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

@Repository
public interface ClusteredDataRepository extends JpaRepository<ClusteredDataModel, Integer> {

	
	public Page<ClusteredDataModel> findAll(Pageable pageable);

    
	

}
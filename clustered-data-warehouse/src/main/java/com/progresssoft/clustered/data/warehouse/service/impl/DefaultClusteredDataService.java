package com.progresssoft.clustered.data.warehouse.service.impl;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.progresssoft.clustered.data.warehouse.exception.ClusteredDataException;
import com.progresssoft.clustered.data.warehouse.exception.ClusteredDataNotFoundException;
import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;
import com.progresssoft.clustered.data.warehouse.repository.ClusteredDataRepository;
import com.progresssoft.clustered.data.warehouse.service.ClusteredDataService;

@Service(value = "clusteredDataService")
public class DefaultClusteredDataService implements ClusteredDataService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultClusteredDataService.class);

	private static final String CLUSTERED_DATA_MODEL_BE_NULL = "clusteredDataModel cannot be null!";
	private static final String CLUSTERED_DATA_MODEL_ID_BE_NULL = "Id cannot be null!";

	@Autowired
	private ClusteredDataRepository clusteredDataRepository;

	@Override
	public ClusteredDataModel add(ClusteredDataModel clusteredDataModel) {
		Preconditions.checkNotNull(clusteredDataModel, CLUSTERED_DATA_MODEL_BE_NULL);
		clusteredDataModel.setId(null);

		LOG.info("start add Clustered Data: fromCurrency [{}] , toCurrency [{}] , amount [{}] ,timestamp [{}] ",
				clusteredDataModel.getFromCurrency(), clusteredDataModel.getToCurrency(),
				clusteredDataModel.getAmount(), clusteredDataModel.getTimestamp());
		ClusteredDataModel saved = clusteredDataRepository.save(clusteredDataModel);
		LOG.info(
				"The Clustered Data has been created successfully :id[{}] fromCurrency [{}] , toCurrency [{}] , amount [{}] ,timestamp [{}] ",
				saved.getId(), saved.getFromCurrency(), saved.getToCurrency(), saved.getAmount(), saved.getTimestamp());
		
		return saved;
	}

	@Transactional(noRollbackFor = {
			ClusteredDataException.class }, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addAll(Set<ClusteredDataModel> set) {
		for (ClusteredDataModel entity : set) {
			clusteredDataRepository.save(entity);
		}
	}

	@Override
	public Page<ClusteredDataModel> findAll(Pageable pageable) {
		
		
		pageable =pageable!=null? pageable:PageRequest.of(0, 10, Sort.by("fromCurrency").ascending());

		return clusteredDataRepository.findAll(pageable);
	}

	@Override
	public ClusteredDataModel findById(Integer id) {
		Preconditions.checkNotNull(id, CLUSTERED_DATA_MODEL_ID_BE_NULL);
 
		Optional<ClusteredDataModel> byId = clusteredDataRepository.findById(id);
		
		if(byId.isEmpty())
		{
			throw new ClusteredDataNotFoundException("ClusteredData for id not found");
		}
		
		return byId.get();
	}
}
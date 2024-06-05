package com.progresssoft.clustered.data.warehouse.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.progresssoft.clustered.data.warehouse.exception.ClusteredDataException;
import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;
import com.progresssoft.clustered.data.warehouse.repository.ClusteredDataRepository;
import com.progresssoft.clustered.data.warehouse.service.ClusteredDataService;

@Service(value = "clusteredDataService")
public class DefaultClusteredDataService implements ClusteredDataService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultClusteredDataService.class);

	private static final String CLUSTERED_DATA_MODEL_BE_NULL = "clusteredDataModel cannot be null!";

	@Autowired
	private ClusteredDataRepository clusteredDataRepository;

	@Override
	public void add(ClusteredDataModel clusteredDataModel) {
		Preconditions.checkNotNull(clusteredDataModel, CLUSTERED_DATA_MODEL_BE_NULL);
		clusteredDataModel.setId(null);

		LOG.info("start add Clustered Data: fromCurrency [{}] , toCurrency [{}] , amount [{}] ,timestamp [{}] ",
				clusteredDataModel.getFromCurrency(), clusteredDataModel.getToCurrency(),
				clusteredDataModel.getAmount(), clusteredDataModel.getTimestamp());
		ClusteredDataModel saved = clusteredDataRepository.save(clusteredDataModel);
		LOG.info(
				"The Clustered Data has been created successfully :id[{}] fromCurrency [{}] , toCurrency [{}] , amount [{}] ,timestamp [{}] ",
				saved.getId(), saved.getFromCurrency(), saved.getToCurrency(), saved.getAmount(), saved.getTimestamp());
	}

	@Transactional(noRollbackFor = {
			ClusteredDataException.class }, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addAll(Set<ClusteredDataModel> set) {
		for (ClusteredDataModel entity : set) {
			clusteredDataRepository.save(entity);
		}
	}
}
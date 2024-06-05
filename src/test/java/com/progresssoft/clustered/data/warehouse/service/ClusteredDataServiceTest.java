package com.progresssoft.clustered.data.warehouse.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;
@SpringBootTest
class ClusteredDataServiceTest {

	@Autowired
	@Qualifier("clusteredDataService")
	private ClusteredDataService clusteredDataService;
	
	private static final Set<ClusteredDataModel>CLUSTERED_DATA_MODELS=new HashSet<>();
	
	static
	{
		CLUSTERED_DATA_MODELS.add(ClusteredDataModel.builder().fromCurrency("JOD").toCurrency("USD").amount(10.0).timestamp(new Date()).build());
		CLUSTERED_DATA_MODELS.add(ClusteredDataModel.builder().fromCurrency("JOD").toCurrency("SAR").amount(10.0).timestamp(new Date()).build());
	}

	@Test
	void testAdd() {
		clusteredDataService.add(CLUSTERED_DATA_MODELS.iterator().next());
	}


	@Test
	void testAddAll() {
		clusteredDataService.addAll(CLUSTERED_DATA_MODELS);

	}

}

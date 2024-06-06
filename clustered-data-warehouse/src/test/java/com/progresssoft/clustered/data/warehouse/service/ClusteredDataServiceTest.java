package com.progresssoft.clustered.data.warehouse.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
		ClusteredDataModel clusteredDataModel = clusteredDataService.add(CLUSTERED_DATA_MODELS.iterator().next());
		assertNotNull(clusteredDataModel);
		assertNotNull(clusteredDataModel.getId());
	}


	@Test
	void testAddAll() {
		clusteredDataService.addAll(CLUSTERED_DATA_MODELS);

	}

    
	@Test
	void testfindAll() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("fromCurrency").ascending());

		Page<ClusteredDataModel> all = clusteredDataService.findAll(pageable);
		assertNotNull(all);
	}
	
	@Test
	void testfindId() {
		
		ClusteredDataModel clusteredDataModel = clusteredDataService.add(CLUSTERED_DATA_MODELS.iterator().next());
		
		ClusteredDataModel byId = clusteredDataService.findById(clusteredDataModel.getId());
		assertNotNull(byId);
		assertNotNull(byId.getId());


	}
}

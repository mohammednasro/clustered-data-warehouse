package com.progresssoft.clustered.data.warehouse.facade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;

class ClusteredDataFacadeTest {

	@Autowired
	@Qualifier("clusteredDataFacade")
	private ClusteredDataFacade clusteredDataFacade;
	
	private static final Set<ClusteredDataDTO>CLUSTERED_DATA_DTOS=new HashSet<>();
	
	static
	{
		CLUSTERED_DATA_DTOS.add(ClusteredDataDTO.builder().fromCurrency("JOD").toCurrency("USD").amount(10.0).timestamp(new Date()).build());
		CLUSTERED_DATA_DTOS.add(ClusteredDataDTO.builder().fromCurrency("JOD").toCurrency("SAR").amount(10.0).timestamp(new Date()).build());
	}

	
	@Test
	void testAdd() {
		clusteredDataFacade.add(CLUSTERED_DATA_DTOS.iterator().next());
	}

	@Test
	void testAddAll() {
		clusteredDataFacade.addAll(ClusteredDataListDTO.builder().list(CLUSTERED_DATA_DTOS).build());
	}

}

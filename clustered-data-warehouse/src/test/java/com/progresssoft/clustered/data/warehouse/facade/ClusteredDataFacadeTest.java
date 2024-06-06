package com.progresssoft.clustered.data.warehouse.facade;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;
import com.progresssoft.clustered.data.warehouse.dto.PageDTO;

@SpringBootTest
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
		clusteredDataFacade.addAll(ClusteredDataListDTO.builder().list(ClusteredDataFacadeTest.CLUSTERED_DATA_DTOS).build());
	}
	
	@Test
	void testfindAll() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("fromCurrency").ascending());

		PageDTO<ClusteredDataDTO> all = clusteredDataFacade.findAll(pageable);
		assertNotNull(all);

	}
	
	@Test
	void testfindId() {
		
		ClusteredDataDTO clusteredDataDTO = clusteredDataFacade.add(CLUSTERED_DATA_DTOS.iterator().next());
		
		ClusteredDataDTO byId = clusteredDataFacade.findById(clusteredDataDTO.getId());
		assertNotNull(byId);
		assertNotNull(byId.getId());

	}

}

package com.progresssoft.clustered.data.warehouse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ClusteredDataControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAdd() throws Exception {
		String requestBody = getClusteredDataDTORequestBody();
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/clustered-data/add").contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testAddAll() throws Exception {
		String requestBody = getClusteredDataListDTORequestBody();
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/clustered-data/add/all")
				.contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private String getClusteredDataDTORequestBody() {
		String requestBody = "{ \"id\": 0, \"fromCurrency\": \"JOD\", \"toCurrency\": \"USD\", \"timestamp\": \"2024-06-05T08:43:26.735Z\", \"amount\": 10 }"; // Your
																																								// request
																																								// body
																																								// JSON
		return requestBody;
	}

	private String getClusteredDataListDTORequestBody() {
		String requestBody = "{  \"list\": [    {      \"fromCurrency\": \"JOD\",      \"toCurrency\": \"USD\",      \"timestamp\": \"2024-06-05T09:24:24.716Z\",      \"amount\": 10    }    ,    {      \"fromCurrency\": \"JOD\",      \"toCurrency\": \"SAR\",      \"timestamp\": \"2024-06-05T09:24:24.716Z\",      \"amount\": 20    }  ]}";
		return requestBody;
	}

}

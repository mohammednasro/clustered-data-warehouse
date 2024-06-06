package com.progresssoft.clustered.data.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;
import com.progresssoft.clustered.data.warehouse.dto.PageDTO;
import com.progresssoft.clustered.data.warehouse.exception.WebserviceValidationException;
import com.progresssoft.clustered.data.warehouse.facade.ClusteredDataFacade;
import com.progresssoft.clustered.data.warehouse.validator.ClusteredDataDTOValidator;
import com.progresssoft.clustered.data.warehouse.validator.ClusteredDataListDTOValidator;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/clustered-data")
@Tag(name = "Clustered Data")
public class ClusteredDataController {

	@Autowired
	@Qualifier("clusteredDataFacade")
	private ClusteredDataFacade clusteredDataFacade;

	@Autowired
	private ClusteredDataDTOValidator clusteredDataDTOValidator;

	@Autowired
	private ClusteredDataListDTOValidator clusteredDataListDTOValidator;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody @Valid ClusteredDataDTO clusteredDataDTO) {

		Errors errors = clusteredDataDTOValidator.validateObject(clusteredDataDTO);

		if (errors.hasErrors()) {
			throw new WebserviceValidationException(errors);
		}

		clusteredDataFacade.add(clusteredDataDTO);
	}

	@PostMapping("/add/all")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAll(@RequestBody @Valid ClusteredDataListDTO clusteredDataListDTO) {

		Errors errors = clusteredDataListDTOValidator.validateObject(clusteredDataListDTO);

		if (errors.hasErrors()) {
			throw new WebserviceValidationException(errors);
		}

		clusteredDataFacade.addAll(clusteredDataListDTO);
	}
	
    @GetMapping("/{id}")
	public ClusteredDataDTO getById(@PathVariable int id) {

		return clusteredDataFacade.findById(id);
	}
    
    @GetMapping
  	public PageDTO<ClusteredDataDTO> getAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "fromCurrency") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

    	Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

  		return clusteredDataFacade.findAll(pageable);
  	}
}

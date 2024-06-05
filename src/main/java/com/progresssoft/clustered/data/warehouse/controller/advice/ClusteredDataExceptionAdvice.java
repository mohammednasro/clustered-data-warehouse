package com.progresssoft.clustered.data.warehouse.controller.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.progresssoft.clustered.data.warehouse.exception.ClusteredDataException;
import com.progresssoft.clustered.data.warehouse.exception.WebserviceValidationException;

@RestControllerAdvice
public class ClusteredDataExceptionAdvice {

	@ExceptionHandler(ClusteredDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String bindExceptionHandler(ClusteredDataException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, List<String>>> bindExceptionHandler(BindException ex) {
		List<String> errors = ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());

		Map<String, List<String>> map = new HashMap<>();
		map.put("errors", errors);
		return new ResponseEntity<Map<String, List<String>>>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(WebserviceValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, List<String>>> webserviceValidationExceptionHandler(
			WebserviceValidationException ex) {

		List<String> errors = ex.getValidationObject().getFieldErrors().stream().map(ef -> ef.getDefaultMessage())
				.collect(Collectors.toList());
		Map<String, List<String>> map = new HashMap<>();
		map.put("errors", errors);
		return new ResponseEntity<Map<String, List<String>>>(map, HttpStatus.BAD_REQUEST);
	}
}
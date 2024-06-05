package com.progresssoft.clustered.data.warehouse.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.util.CurrencyUtil;

@Component
public class ClusteredDataDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ClusteredDataDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClusteredDataDTO dto = (ClusteredDataDTO) target;

		if (!CurrencyUtil.isValid(dto.getFromCurrency(), dto.getToCurrency())) {
			errors.rejectValue("fromCurrency", "Invalid fromCurrency", "Invalid fromCurrency");
			errors.rejectValue("toCurrency", "Invalid toCurrency", "Invalid toCurrency");
		}

	}

}
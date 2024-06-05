package com.progresssoft.clustered.data.warehouse.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataDTO;
import com.progresssoft.clustered.data.warehouse.dto.ClusteredDataListDTO;
import com.progresssoft.clustered.data.warehouse.util.CurrencyUtil;

@Component
public class ClusteredDataListDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ClusteredDataListDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClusteredDataListDTO dto = (ClusteredDataListDTO) target;

		if (dto == null || CollectionUtils.isEmpty(dto.getList())) {
			errors.rejectValue("list", "Invalid list", "Invalid list");
			return;
		}

		for (ClusteredDataDTO clusteredDataDTO : dto.getList()) {
			if (!CurrencyUtil.isValid(clusteredDataDTO.getFromCurrency(), clusteredDataDTO.getToCurrency())) {
				errors.rejectValue("list", "Invalid list", "Invalid currencies list ");
				return;
			}
		}
	}

}
package com.progresssoft.clustered.data.warehouse.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="currency")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyModel {
	@Id
	@Column(name= "isocode")
	private String isoCode;
	
	@Column(name= "name")
	private String name;
}

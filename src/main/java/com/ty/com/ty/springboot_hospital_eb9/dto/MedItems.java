package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "name should not be Null")
	@NotBlank(message = "name should not be Blank")
	private String name;
	private String description;
	@NotNull (message = "name should not be Null")
	@Min(1)
	private int pills;
	@ManyToOne
	private MedOrder order;

	

}

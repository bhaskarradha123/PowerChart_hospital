package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "location should not be Null")
	@NotBlank(message = "location should not be Blank")
	private String location;
	@NotNull (message = "street should not be Null")
	@NotBlank(message = "street should not be Blank")
	private String Street;
	private String road_cross;
	@NotNull(message = "pincode is mandatory")
	@Size(min = 5,max = 10)
	
	private String pincode;

	

}

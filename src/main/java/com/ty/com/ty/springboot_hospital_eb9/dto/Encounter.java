package com.ty.com.ty.springboot_hospital_eb9.dto;

 

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "reason should not be Null")
	@NotBlank(message = "reason should not be Blank")
	private String reason;
	@NotNull (message = "cost should not be Null")
	@DecimalMax("1000000000000000000000.0")
	@DecimalMin("100.0")
	private double cost;

	@ManyToOne
	private Person person;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Branch> branches;
}

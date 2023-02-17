package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

 
 

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "street should not be Null")
	@NotBlank(message = "street should not be Blank")
	private String name;
	@NotNull(message = "phone num is mandatory")
	@Size(min = 10,max = 10)
	@Pattern(regexp = "^[6-9][0-9]{9}$")
	private String phone;
	@NotNull (message = "street should not be Null")
	@NotBlank(message = "street should not be Blank")
	private String manager;

	@ManyToOne
	private Hospital hospital;
	
	@OneToOne 
	private Address address;


	
}

package com.ty.com.ty.springboot_hospital_eb9.dto;

 

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
 

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "name should not be Null")
	@NotBlank(message = "name should not be Blank")
	private String name;
	@NotNull (message = "email should not be Null")
	@NotBlank(message = "email should not be Blank" )
	//@Pattern(regexp = "@")
	private String email;
	@NotNull (message = "website should not be Null")
	@NotBlank(message = "website should not be Blank")
	private String website;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}

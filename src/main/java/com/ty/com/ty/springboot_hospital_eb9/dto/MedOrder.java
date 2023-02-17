package com.ty.com.ty.springboot_hospital_eb9.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull (message = "name should not be Null")
	@NotBlank(message = "name should not be Blank")
	private String name;
	
	private int age;
	private String gender;
	@JsonFormat(pattern = "MM-DD-YYYY")
	//@javax.persistence.Temporal(TemporalType.DATE)
	private Date date=new Date(System.currentTimeMillis());
	
	@ManyToOne
	private Encounter encounter;
	

}

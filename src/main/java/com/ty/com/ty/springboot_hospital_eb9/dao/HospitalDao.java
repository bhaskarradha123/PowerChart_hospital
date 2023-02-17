package com.ty.com.ty.springboot_hospital_eb9.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;
import com.ty.com.ty.springboot_hospital_eb9.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository repository;

	public Hospital SaveHospital(Hospital hospital) {
		return repository.save(hospital);

	}
	
	public Hospital updateHospital(int id, Hospital hospital)
	{
		
		if(repository.findById( id).isPresent())
		{
			hospital.setId(id);
			return repository.save( hospital);
		}else {
			return null;
		}
		
	}
	
	public Hospital deleteHospital(int id)
	{
		if(repository.findById( id).isPresent())
		{
			Hospital hospital=repository.findById( id).get();
			 repository.delete(hospital);
			return hospital;
		}
		else {
			return null;
		}
	}
	
	public Hospital getById(int id)
	{
		if(repository.findById( id).isPresent())
		{
			Hospital hospital=repository.findById( id).get();
			return hospital;
		}
		else {
			return null;
		}
	}
	
	public List<Hospital> getAllHospitals()
	{
		return repository.findAll();
	}
	
	public Hospital getByEmail(String email)
	{
		 return repository.getByEmail(email);
	}

}

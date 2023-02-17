package com.ty.com.ty.springboot_hospital_eb9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;

public interface BranchRepository extends  JpaRepository< Branch, Integer> {
	
	@Query("Select b from Branch  b where b.hospital=?1")
 	public List<Branch> getBranchByHospitalId(Hospital hospital);
}

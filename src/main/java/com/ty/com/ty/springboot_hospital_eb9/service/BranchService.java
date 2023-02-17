package com.ty.com.ty.springboot_hospital_eb9.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByBranchException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByHospitalException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByBranchException;
import com.ty.com.ty.springboot_hospital_eb9.dao.BranchDao;
import com.ty.com.ty.springboot_hospital_eb9.dao.HospitalDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid, int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		Branch branchdb=branchDao.saveBarnch(branch, hid, aid);
		Hospital hospital=hospitalDao.getById(hid);
		if(hospital!=null) {
			if(branchdb != null) {
				structure.setMessage("Sucessfully Branch is saved ");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData( branchdb);
				return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
				}else {
					throw new IdNotFoundByAddressException("Pls check the address id "+aid+" is save the Branch");
				}
		}
			
			else {
				throw new IdNotFoundByHospitalException("Pls check the hospital id "+hid+" is save the branch");
			}
		}

	

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id) {
		Branch branchdb = branchDao.updatebranch(branch, id);
		if (branchdb != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
			structure.setMessage("Sucessfully Branch is Updated ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchDao.updatebranch(branch, id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByBranchException("Pls check the branch id "+id+" is not exist to update");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		Branch branchdb = branchDao.deleteBranch(id);
		if (branchdb != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
			structure.setMessage("Sucessfully Branch is Deleted ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchdb);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByBranchException("Pls check the branch id "+id+" is not exist to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranch(int id) {
		Branch branchdb = branchDao.deleteBranch(id);
		if (branchdb != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
			structure.setMessage("Sucessfully Branch is Found ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchdb);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByBranchException("Pls check the address id "+id+" is not exist to display");
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(int id) {
		 
		List<Branch> list=branchDao.getAllBranchesByHospitalId(id);
		if( list != null)
		{
			ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		
			structure.setMessage("Sucessfully Branchs  is Found ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundByHospitalException("Hospital id is not Found");
		}
	}

}

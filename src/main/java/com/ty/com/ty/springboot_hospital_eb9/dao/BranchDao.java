package com.ty.com.ty.springboot_hospital_eb9.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.com.ty.springboot_hospital_eb9.dto.Address;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;
import com.ty.com.ty.springboot_hospital_eb9.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepository repository;

	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private AddressDao addressDao;

	public Branch saveBarnch(Branch branch, int hid, int aid) {
		Hospital hospital = hospitalDao.getById(hid);
		Address address=addressDao.getById(aid);
		if(hospital != null && address != null) {
		branch.setAddress(address);
		branch.setHospital(hospital);
		return repository.save(branch);
		}else {
			return null;
		}
	}

	public Branch updatebranch(Branch branch, int id) {

		if (repository.findById(id).isPresent()) {
			Branch branchdb = repository.findById(id).get();
			branch.setId(id);
			branch.setHospital(branchdb.getHospital());
			branch.setAddress(branchdb.getAddress());
			return repository.save(branch);

		} else {
			return null;
		}

	}

	public Branch deleteBranch(int id) {
		if (repository.findById(id).isPresent()) {
			Branch branch = repository.findById(id).get();
			repository.delete(branch);
			return branch;
		} else {
			return null;
		}
	}

	public Branch getBranchById(int id) {
		if (repository.findById(id).isPresent()) {
			Branch branch = repository.findById(id).get();
			return branch;
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranches() {
		return repository.findAll();

	}

	public Branch getHospital(int id) {
		if (repository.findById(id).isPresent()) {
			Branch branch = repository.findById(id).get();

			return branch;
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranchesByHospitalId(int id) {
		Hospital hospital = hospitalDao.getById(id);
		if (hospital != null) {
			return repository.getBranchByHospitalId(hospital);

		} else {
			return null;
		}
	}

}

package com.ty.com.ty.springboot_hospital_eb9.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByHospitalException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByHospitalException;
import com.ty.com.ty.springboot_hospital_eb9.dao.HospitalDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@Service
public class ServiceHospital {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setMessage("Sucessfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.SaveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updatehospital(int id, Hospital hospital) {
		Hospital hospitaldb = dao.updateHospital(id, hospital);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		if (hospitaldb != null) {

			responseStructure.setMessage("Sucessfully Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByHospitalException("Pls check the hospital id "+id+" is not exist to update");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.deleteHospital(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		if (hospital != null) {

			responseStructure.setMessage("Sucessfully Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByHospitalException("Pls check the hospital id "+id+" is not exist to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getById(int id) {
		Hospital hospital = dao.getById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		if (hospital != null) {

			responseStructure.setMessage("Sucessfully Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByHospitalException("Pls check the hospital id "+id+" is not exist to display");
		}
	}
}

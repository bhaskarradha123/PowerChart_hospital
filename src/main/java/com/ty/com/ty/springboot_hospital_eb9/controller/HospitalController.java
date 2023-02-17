package com.ty.com.ty.springboot_hospital_eb9.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.com.ty.springboot_hospital_eb9.dao.HospitalDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Hospital;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.ServiceHospital;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private ServiceHospital serviceHospital;
	@Autowired
	private HospitalDao dao;
	@ApiOperation(value = "save Hospital", notes = "Api is used to save Hospital  object")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created ")}
		)
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital( @Valid @RequestBody Hospital hospital) {
		return serviceHospital.saveHospital(hospital);
	}

	@PutMapping("/hospital")
	@ApiOperation(value = "update Hospital", notes = "Api is used to update Hospital with given Hospital id")
	@ApiResponses({@ApiResponse(code=201,message="Hospital object is updated "),
		@ApiResponse(code=404,message="Id not Found for the given Hospital Id")})
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
		@Valid	@RequestBody Hospital hospital) {
		return serviceHospital.updatehospital(id, hospital);
	}

	@DeleteMapping("/hospital")
	@ApiOperation(value = "Delete Hospital", notes = "Api is used to Delete Hopsital with given Hospital id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Deleted "),
		@ApiResponse(code=404,message="Id not Found for the given Hospital Id")})
	public ResponseEntity<ResponseStructure<Hospital>> deletehospital(@RequestParam int id) {
		return serviceHospital.deleteHospital(id);
	}

	@GetMapping("/hospital")
	@ApiOperation(value = "to display Hospital", notes = "Api is used to display Hospital with given Hospital id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message="Id not Found for the given Hospital Id")})
	
	public ResponseEntity<ResponseStructure<Hospital>> getById(@RequestParam int id) {
		return serviceHospital.getById(id);
	}

	@GetMapping("/hospital1")
	public List<Hospital> getAllHospital() {
		return dao.getAllHospitals();
	}

}

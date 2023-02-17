package com.ty.com.ty.springboot_hospital_eb9.controller;

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

import com.ty.com.ty.springboot_hospital_eb9.dto.Address;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService addresService;

	@PostMapping("/address")
	@ApiOperation(value = "save address", notes = "Api is used to save address ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully saved address")})
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return addresService.saveAddress(address);
	}

	@PutMapping("/address")
	@ApiOperation(value = "update address", notes = "Api is used to update address with given address id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given address Id")})
	public ResponseEntity<ResponseStructure<Address>> updateHospital(@RequestParam int id,
		@Valid	@RequestBody Address address) {
		return addresService.updateAddress(id, address);
	}

	@DeleteMapping("/address")


	@ApiOperation(value = "deletee address", notes = "Api is used to delete address with given address id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="Id not Found for the given address Id")})
	public ResponseEntity<ResponseStructure<Address>> deletehospital(@RequestParam int id) {
		return addresService.deleteAddress(id);
	}

	@GetMapping("/address")
	@ApiOperation(value = "display address", notes = "Api is used to display address with given address id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message="Id not Found for the given address Id")})
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id) {
		return addresService.getById(id);
	}

}

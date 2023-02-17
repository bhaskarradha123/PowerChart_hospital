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

import com.ty.com.ty.springboot_hospital_eb9.dto.Person;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping("/person")
	@ApiOperation(value = "save person", notes = "Api is used to save person ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created ")})
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid@RequestBody Person person) {
		return service.savePerson(person);
	}

	@PutMapping("/person")
	@ApiOperation(value = "update Person", notes = "Api is used to update Person with given person id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given person Id")})
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id,@Valid@RequestBody Person person) {
		return service.updatePerson(id,person);
	}

	@DeleteMapping("/person")
	@ApiOperation(value = "delete Person", notes = "Api is used to delete Person with given person id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="Id not Found for the given person Id")})
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

	@GetMapping("/person")
	@ApiOperation(value = "display person", notes = "Api is used to display person with given person id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message="Id not Found for the given person Id")})
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getByPersonId(id);
	}
}

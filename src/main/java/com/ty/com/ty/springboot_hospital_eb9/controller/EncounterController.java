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

import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService encounterService;

	@PostMapping("/encounter") 
	@ApiOperation(value = "save Encounter", notes = "Api is used to save Encounter with given person id and branch id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="Id not Found for the given Hperson Id or branchid")})
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid@RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}

	@PutMapping("/encounter")
	@ApiOperation(value = "update encounter", notes = "Api is used to update encounter with given encounter id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated"),
		@ApiResponse(code=404,message="Id not Found for the given encounter Id")})
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@Valid@RequestBody Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {
		return encounterService.updateEncounter(encounter, eid, bid);
	}

	@DeleteMapping("/encounter")
	@ApiOperation(value = "delete encounter", notes = "Api is used to delete encounter with given encounter id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="Id not Found for the given encounter Id")})
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		return encounterService.deleteEncounter(eid);
	}

	@GetMapping("/encounter")
	@ApiOperation(value = "display encounter", notes = "Api is used to display encounter with given encounter id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display"),
		@ApiResponse(code=404,message="Id not Found for the given encounter Id")})
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int eid) {
		return encounterService.getEncounterById(eid);
	}

}

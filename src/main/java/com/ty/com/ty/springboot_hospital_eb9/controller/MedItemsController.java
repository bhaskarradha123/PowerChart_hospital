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

import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.MedItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {
	@Autowired
	private MedItemsService service;
	
	
	
	@PostMapping("/item")
	@ApiOperation(value = "save meditems", notes = "Api is used to save meditems with given medorder id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="Id not Found for the given medorder Id")})
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@Valid@RequestBody MedItems medItems,@RequestParam int oid) {
		return service.saveMedItems(medItems,oid);
	}

	@PutMapping("/item")
	@ApiOperation(value = "update item", notes = "Api is used to update item with given meditem id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given meditem Id")})
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestParam int id,
		@Valid	@RequestBody MedItems medItems) {
		return service.updateMedItems(id, medItems);
	}

	@DeleteMapping("/item")
	@ApiOperation(value = "delete item", notes = "Api is used to delete item with given meditem id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="Id not Found for the given meditem Id")})
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@RequestParam int id) {
		return service.deleteMedItems(id);
	}

	@GetMapping("/item")
	@ApiOperation(value = "display meditem", notes = "Api is used to display meditem with given meditem id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message="Id not Found for the given meditem Id")})
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int id) {
		return service.getMedItemsById(id);
	}

	
@GetMapping("/getorder")
	
	@ApiOperation(value = "to display all meditems based on medorder id", notes = "Api is used to display all meditems with given medorder id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display all meditems based on medorder id "),
		@ApiResponse(code=404,message=" list of meditems  not found for the given medorder Id")})
	public ResponseEntity<ResponseStructure<List< MedItems>>> getMedItemsByMedORderId(@RequestParam int id)
	{
		return service.getMedItemsByMedORder(id);
	}

	
	
	
	
	
	
}

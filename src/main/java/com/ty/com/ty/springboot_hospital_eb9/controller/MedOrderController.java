package com.ty.com.ty.springboot_hospital_eb9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.MedOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {
	@Autowired
	private MedOrderService service;
	
	

	@PostMapping("/order")
	@ApiOperation(value = "save order", notes = "Api is used to save  order with given encounter id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="Id not Found for the given encounterId")})
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder order,@RequestParam int eid) {
		return service.saveMedOrder(order, eid);
	}

	@PutMapping("/order")
	@ApiOperation(value = "update order", notes = "Api is used to update order with given order id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated"),
		@ApiResponse(code=404,message="Id not Found for the given order Id")})
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id,
			@RequestBody MedOrder order) {
		return service.updateMedOrder(id, order);
	}

	@DeleteMapping("/order")
	@ApiOperation(value = "delete order", notes = "Api is used to delete order with given order id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted"),
		@ApiResponse(code=404,message="Id not Found for the given order Id")})
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}

	@GetMapping("/order")
	@ApiOperation(value = "display order", notes = "Api is used to display order with given order id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to dispaly "),
		@ApiResponse(code=404,message="Id not Found for the given order Id")})
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return service.getMedOrderById(id);
	}


}

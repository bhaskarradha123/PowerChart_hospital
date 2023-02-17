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

import com.ty.com.ty.springboot_hospital_eb9.dao.BranchDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchServic;
	
	@Autowired
	private BranchDao branchDao;

	@PostMapping("/branch")
	@ApiOperation(value = "save Branch", notes = "Api is used to save Branch with given Hospital id and address id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="Id not Found for the given Hospital Id or adddress id")})
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid@RequestBody Branch branch, @RequestParam int hid,@RequestParam int aid) {
		return branchServic.saveBranch(branch, hid,aid);
	}

	@PutMapping("/branch")
	@ApiOperation(value = "update Branch", notes = "Api is used to update Branch with given branch id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated branch object "),
		@ApiResponse(code=404,message="Id not Found for the given branch Id")})
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid @RequestBody Branch branch, @RequestParam int id) {
		return branchServic.updateBranch(branch, id);
	}

	@DeleteMapping("/branch")
	@ApiOperation(value = "delete Branch", notes = "Api is used to delete Branch with given branch id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted  the branch object"),
		@ApiResponse(code=404,message="Id not Found for the given branch Id")})
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchServic.deleteBranch(id);
	}

	@GetMapping("/branch")
	@ApiOperation(value = "to display Branch", notes = "Api is used to display Branch with given branch id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display"),
		@ApiResponse(code=404,message="Id not Found for the given branch Id")})
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@RequestParam int id) {
		return branchServic.getBranch(id);
	}
	
	@GetMapping("/branchall")
	@ApiOperation(value = "to display all Branches", notes = "Api is used to display all Branches")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display all branches "),
		@ApiResponse(code=404,message="no branch is available to display branches")})
	public  List<Branch> getBranch() {
		return branchDao.getAllBranches();
		
	}
	
	@GetMapping("/gethospital")
	
	@ApiOperation(value = "to display all Branch based on hospital id", notes = "Api is used to display all Branches with given Hospital id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display all branches based on hospital id "),
		@ApiResponse(code=404,message=" list of branches found for the given Hospital Id")})
	public ResponseEntity<ResponseStructure<List< Branch>>> getBranchByHospitalId(@RequestParam int id)
	{
		return branchServic.getBranchByHospital(id);
	}

}

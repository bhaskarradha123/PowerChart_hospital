package com.ty.com.ty.springboot_hospital_eb9.exceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByBranchException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByEncounterException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByHospitalException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedItemsException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByMedOrderException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.IdNotFoundByPersonException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByAddressException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByBranchException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByEncounterlException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByHospitalException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByMedItemsException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NoSuchElementFoundByPersonException;
import com.ty.com.ty.springboot_hospital_eb9.Exception.NullPointerExceptionByMedORder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	// IdNotfindException
	// Hospital
	@ExceptionHandler(IdNotFoundByHospitalException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByHospitalException(
			IdNotFoundByHospitalException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(" Hospital Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Address
	@ExceptionHandler(IdNotFoundByAddressException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByaddressException(
			IdNotFoundByAddressException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(" Address Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Branch
	@ExceptionHandler(IdNotFoundByBranchException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByBranchException(
			IdNotFoundByBranchException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Branch Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Person
	@ExceptionHandler(IdNotFoundByPersonException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByPersonException(
			IdNotFoundByPersonException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Person Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(IdNotFoundByMedItemsException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByMedItemsException(
			IdNotFoundByMedItemsException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("MedItems Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	

	// encounter
	@ExceptionHandler(IdNotFoundByEncounterException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByEncounterException(
			IdNotFoundByEncounterException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Encounter Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundByMedOrderException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundByMedOrderException(
			IdNotFoundByMedOrderException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("MedORder Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerExceptionByMedORder.class)
	public ResponseEntity<ResponseStructure<String>> NullPointerByMedOrderException(
			NullPointerExceptionByMedORder exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("MedORder Id is Not Found There is No Data found for Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	// NoSuchElementException
	// Address
	@ExceptionHandler(NoSuchElementFoundByAddressException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByAddressException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In Address Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Hospital
	@ExceptionHandler(NoSuchElementFoundByHospitalException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByHospitalException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In Hospital Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Branch
	@ExceptionHandler(NoSuchElementFoundByBranchException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByBranchException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In Branch Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Person
	@ExceptionHandler(NoSuchElementFoundByPersonException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByPersonException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In Person Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	// Encounter
	@ExceptionHandler(NoSuchElementFoundByEncounterlException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByEncounterlException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In Encounter Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NoSuchElementFoundByMedItemsException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(
			NoSuchElementFoundByMedItemsException exception) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("No Such Element is Found In MedItems Entity beacuse id is not Exist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	

	// constrainvilationException
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ResponseStructure<String>> constraintViolationException(
//			ConstraintViolationException exception) {
//		ResponseStructure<String> structure = new ResponseStructure<String>();
//
//		structure.setMessage(exception.getMessage());
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setData(" Constraint Validation Exception fileds not given properlyExist");
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
//	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 List< ObjectError> error =ex.getAllErrors();
		 Map< String , String> map=new HashMap<String, String>( );
		 for(ObjectError objectError: error)
		 {
			 String filedName=((FieldError)objectError).getField();
			 String message=((FieldError)objectError).getDefaultMessage();
			 map.put(filedName, message);
			 
		 }
		 return new ResponseEntity<Object> (map,HttpStatus.BAD_REQUEST);
	}
	
	
	


	    @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
	        StringBuilder errorMessage = new StringBuilder();
	        ex.getConstraintViolations().forEach(violation ->
	                errorMessage.append(violation.getMessage()).append("; "));
	        return ResponseEntity.badRequest().body(errorMessage.toString());
	    }
	
	    
	    
	 @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	 public ResponseEntity<ResponseStructure<String>> sqlintegrityconstraintViolation(SQLIntegrityConstraintViolationException ex){
		 
		 ResponseStructure<String> structure = new ResponseStructure<String>();

			structure.setMessage(ex.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Cannot delete or update a parent row: a foreign key constraint fails.");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		 
	 }
		 
		
	 

	
	
	
	
	
	
	
	
	

}

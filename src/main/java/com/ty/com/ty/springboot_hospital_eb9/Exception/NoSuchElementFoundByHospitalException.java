package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class NoSuchElementFoundByHospitalException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByHospitalException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByHospitalException() {
		super();

	}

}
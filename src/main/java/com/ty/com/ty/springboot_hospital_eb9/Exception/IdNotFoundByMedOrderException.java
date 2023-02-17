package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class IdNotFoundByMedOrderException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByMedOrderException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByMedOrderException() {
		super();

	}
}

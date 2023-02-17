package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class IdNotFoundByAddressException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByAddressException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByAddressException() {
		super();

	}

}
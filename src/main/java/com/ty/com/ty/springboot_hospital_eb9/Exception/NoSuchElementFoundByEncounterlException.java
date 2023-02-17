package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class NoSuchElementFoundByEncounterlException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByEncounterlException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByEncounterlException() {
		super();

	}

}
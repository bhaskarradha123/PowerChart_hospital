package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class NoSuchElementFoundByPersonException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByPersonException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByPersonException() {
		super();

	}

}
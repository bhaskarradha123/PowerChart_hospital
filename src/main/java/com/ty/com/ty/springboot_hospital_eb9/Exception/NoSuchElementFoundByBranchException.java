package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class NoSuchElementFoundByBranchException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByBranchException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByBranchException() {
		super();

	}

}
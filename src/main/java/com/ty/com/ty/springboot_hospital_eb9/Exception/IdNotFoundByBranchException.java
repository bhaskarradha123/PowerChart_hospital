package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class IdNotFoundByBranchException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByBranchException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByBranchException() {
		super();

	}

}

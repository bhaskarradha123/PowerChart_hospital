package com.ty.com.ty.springboot_hospital_eb9.Exception;

public class IdNotFoundByMedItemsException extends RuntimeException {
	
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public IdNotFoundByMedItemsException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundByMedItemsException() {
		super();

	}

}

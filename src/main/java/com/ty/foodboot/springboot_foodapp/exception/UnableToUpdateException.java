package com.ty.foodboot.springboot_foodapp.exception;

public class UnableToUpdateException extends RuntimeException{
	
	private String message="No Id Fount To Update";

	public UnableToUpdateException(String message) {
		super();
		this.message = message;
	}
	
	public UnableToUpdateException() {
		
	}
	
	public String getMessage() {
		return message;
	}
	
	

}

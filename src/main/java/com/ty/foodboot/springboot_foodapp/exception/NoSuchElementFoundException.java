package com.ty.foodboot.springboot_foodapp.exception;

public class NoSuchElementFoundException extends RuntimeException{
	
	private String message="No Such Element Found in Deta Base";

	public NoSuchElementFoundException(String message) {
		super();
		this.message = message;
	}
	
	public NoSuchElementFoundException() {
	}
	
 @Override
 public String getMessage() {
	 return message;
 }
 

	
}

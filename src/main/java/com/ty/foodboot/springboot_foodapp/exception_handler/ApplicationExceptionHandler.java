package com.ty.foodboot.springboot_foodapp.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.foodboot.springboot_foodapp.exception.NoSuchElementFoundException;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementFoundHandler(NoSuchElementFoundException elementFoundException ){
		ResponseStructure<String > responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(elementFoundException.getMessage());
		return responseEntity;
	}
	
	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseEntity<ResponseStructure<String>> unAbleToUpdate(UnableToUpdateException exception ){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unabele To Upadate");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}

}

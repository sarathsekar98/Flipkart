package com.Flipkart.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Homeexception {
	
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public UserNotFoundException usernotfound(UserNotFoundException userNotFoundException)
	{
		return userNotFoundException;
	}
	
	

}

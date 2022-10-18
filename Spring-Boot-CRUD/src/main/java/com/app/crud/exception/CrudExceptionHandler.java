package com.app.crud.exception;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CrudExceptionHandler {

	@ExceptionHandler(AllFieldMandatoryException.class)
	public ResponseEntity<ResponseError> AllFieldMandatoryExceptionHandler(AllFieldMandatoryException e, HttpServletRequest request)
	{
		ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.value(),e.getMessage(),HttpStatus.NOT_FOUND,new Date(),request.getRequestURI());
		return new ResponseEntity<ResponseError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullValueException.class)
	public ResponseEntity<String> NullValueExceptionHandler(NullValueException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}

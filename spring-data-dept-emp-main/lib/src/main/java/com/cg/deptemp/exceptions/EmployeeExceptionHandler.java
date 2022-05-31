package com.cg.deptemp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exception){
		return new ResponseEntity<Object>("Employee not found...",HttpStatus.NOT_FOUND);
	}
}

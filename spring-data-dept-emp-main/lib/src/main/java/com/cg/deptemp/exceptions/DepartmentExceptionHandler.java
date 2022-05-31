package com.cg.deptemp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler {
	@ExceptionHandler(value=DepartmentNotFoundException.class)
	public ResponseEntity<Object> exception(DepartmentNotFoundException exception){
		return new ResponseEntity<Object>("Department not found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=DepartmentAlreadyExistException.class)
	public ResponseEntity<Object> exception(DepartmentAlreadyExistException exception){
		return new ResponseEntity<Object>("Department Already Exists...",HttpStatus.NOT_FOUND);
	}
}

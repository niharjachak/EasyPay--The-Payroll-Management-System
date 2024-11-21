package com.hexaware.easyspay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

	
	@ExceptionHandler(PayrollNotFoundException.class)
	public ResponseEntity<String> handlePayrollNotFoundException(PayrollNotFoundException e){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(LeavesRequestException.class)
	public ResponseEntity<String> handleLeavesRequestException (LeavesRequestException e){
		return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	
	public ResponseEntity<String> handleUnauthorizedActionException (UnAuthorizedActionException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}

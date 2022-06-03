package com.exam.prime.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exam.prime.exception.InvalidCredentialsException;
import com.exam.prime.exception.InvalidInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Map<String, Object>> handleInvalidInput(InvalidInputException invalidInputException){		
		Map<String, Object> respBuilder = new HashMap<>();
		respBuilder.put("errorCode" ,invalidInputException.getErrorCode());
		respBuilder.put("errorMessage",invalidInputException.getErrorMsg());
		return  ResponseEntity.ok(respBuilder);
	}

	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Map<String, Object>> handleInvalidInput(InvalidCredentialsException invalidCredentialsException){		
		Map<String, Object> respBuilder = new HashMap<>();
		respBuilder.put("errorCode" ,invalidCredentialsException.getErrorCode());
		respBuilder.put("errorMessage",invalidCredentialsException.getErrorMsg());
		return  ResponseEntity.ok(respBuilder);
	}
}

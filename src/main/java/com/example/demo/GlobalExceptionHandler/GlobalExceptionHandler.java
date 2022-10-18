package com.example.demo.GlobalExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.NonUniqueResultException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.support.InvocableHandlerMethod;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException exception){
		
		Map<String, String> errorMap = new HashMap<String, String>();
		exception.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument1(ConstraintViolationException exception){
		
		Map<String, String> errorMap = new HashMap<String, String>();
//		exception.getBindingResult().getFieldErrors().forEach(error ->{
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
		
		errorMap.put(exception.getConstraintName(), exception.getMessage());
		System.out.println(exception.getConstraintName());
		System.out.println(exception.getMessage());
		
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(InvocableHandlerMethod.class)
//	public ResponseEntity<Map<String, String>> handleInvalidArgument2(InvocableHandlerMethod exception){
//		
//		Map<String, String> errorMap = new HashMap<String, String>();
////		exception.getBindingResult().getFieldErrors().forEach(error ->{
////			errorMap.put(error.getField(), error.getDefaultMessage());
////		});
//		
//		errorMap.put(exception., exception.getMessage());
//		System.out.println(exception.getLocalizedMessage());
//		System.out.println(exception.getMessage());
//		
//		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
//	}
//	
	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<Map<String, String>> handleNonUniqueResultException(NonUniqueResultException exception){
		
		Map<String, String> errorMap = new HashMap<String, String>();
//		exception.getBindingResult().getFieldErrors().forEach(error ->{
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
		
//		errorMap.put(exception.toString(), exception.getMessage());
		errorMap.put(exception.getLocalizedMessage(), exception.getMessage());
//		System.out.println(exception.getStackTrace().toString());
//		for (StackTraceElement x : exception.getStackTrace()) {
//			System.out.println(x);
//		}
//		System.out.println(exception.getCause());
		
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		
		Map<String, String> errorMap = new HashMap<String, String>();
//		exception.getBindingResult().getFieldErrors().forEach(error ->{
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
		errorMap.put(exception.getMessage(), exception.getLocalizedMessage());
		
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
}

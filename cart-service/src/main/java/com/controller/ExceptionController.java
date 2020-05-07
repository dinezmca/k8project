package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dto.ErrorDto;
import com.exception.NotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<List<ErrorDto>> handleNotFoundException(NotFoundException e){
		final String message ="Provided Id is not found "+e.getMessage();
		final List<ErrorDto>  errorList = new ArrayList<ErrorDto>();
		errorList.add(new ErrorDto("404", message, e.getField()));
		return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
		
	}

}

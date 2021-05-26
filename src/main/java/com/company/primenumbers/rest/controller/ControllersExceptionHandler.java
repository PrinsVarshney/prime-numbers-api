package com.company.primenumbers.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.primenumbers.rest.dto.ErrorDto;
import com.company.primenumbers.rest.exception.InvalidInputException;
import com.company.primenumbers.rest.exception.LimitNotSupportedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllersExceptionHandler {
	
	@ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleInvalidInputException(InvalidInputException ex) {
    	log.error("InvalidInputException : {}", ex.getMessage());
        return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
    }
    
	@ExceptionHandler(LimitNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleLimitNotSupportedException(LimitNotSupportedException ex) {
    	log.error("LimitNotSupportedException : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(ex.getMessage()));
    }
	
}

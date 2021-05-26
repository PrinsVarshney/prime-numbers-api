package com.company.primenumbers.rest.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = -2901736260649802706L;

	public InvalidInputException(String message) {
        super(message);
        log.debug("InvalidInputException, message : {}", message);
    }
	
}

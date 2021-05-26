package com.company.primenumbers.rest.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LimitNotSupportedException extends RuntimeException {

    private static final long serialVersionUID = -2901736260649802707L;

	public LimitNotSupportedException(String message) {
        super(message);
        log.debug("LimitNotSupportedException, message : {}", message);
    }
	
}

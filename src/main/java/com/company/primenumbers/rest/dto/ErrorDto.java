package com.company.primenumbers.rest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto implements Serializable {
    
	private static final long serialVersionUID = 7007981017631470612L;
	
	private final String error;
       
}

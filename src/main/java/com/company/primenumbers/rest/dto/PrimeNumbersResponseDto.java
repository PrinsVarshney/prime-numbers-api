package com.company.primenumbers.rest.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrimeNumbersResponseDto implements Serializable {
    
	private static final long serialVersionUID = 7007981017631470611L;
	
	private final BigInteger initial;
    private final List<BigInteger> primes;
    
}

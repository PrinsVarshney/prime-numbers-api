package com.company.primenumbers.rest.service;

import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;

public interface IPrimeNumbersService {
	
	PrimeNumbersResponseDto getPrimeNumbers(String providedNumber, String providedAlgorithm);

}

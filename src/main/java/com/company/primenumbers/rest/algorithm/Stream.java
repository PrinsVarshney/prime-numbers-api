package com.company.primenumbers.rest.algorithm;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream implements IPrimeNumbersAlgorithm {
	
	@Override
	public List<BigInteger> generatePrimeNumbers(BigInteger providedNumber) {
		return IntStream.rangeClosed(2, providedNumber.intValue())
			      .filter(this::isPrime)
			      .mapToObj(BigInteger::valueOf)
			      .collect(Collectors.toList());
	}
	
	private boolean isPrime(int number) {
	    return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
	      .allMatch(n -> number % n != 0);
	}
	
}

package com.company.primenumbers.rest.algorithm;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class OptimizedBruteForce implements IPrimeNumbersAlgorithm {
	
	@Override
	public List<BigInteger> generatePrimeNumbers(BigInteger providedNumber) {
	    List<BigInteger> primeNumbers = new LinkedList<>();
	    if (providedNumber.intValue() >= 2) {
	        primeNumbers.add(BigInteger.valueOf(2));
	    }
	    for (int i = 3; i <= providedNumber.intValue(); i += 2) {
	        if (isOptimzedPrimeBruteForce(i)) {
	            primeNumbers.add(BigInteger.valueOf(i));
	        }
	    }
	    return primeNumbers;
	}
	
	private boolean isOptimzedPrimeBruteForce(int number) {
	    for (int i = 3; i * i <= number; i += 2) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
}

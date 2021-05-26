package com.company.primenumbers.rest.algorithm;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class BruteForce implements IPrimeNumbersAlgorithm {
	
	@Override
	public List<BigInteger> generatePrimeNumbers(BigInteger providedNumber) {
	    List<BigInteger> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= providedNumber.intValue(); i++) {
	        if (isPrimeBruteForce(i)) {
	            primeNumbers.add(BigInteger.valueOf(i));
	        }
	    }
	    return primeNumbers;
	}
	
	private boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
}

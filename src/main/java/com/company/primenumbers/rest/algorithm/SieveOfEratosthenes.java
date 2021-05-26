package com.company.primenumbers.rest.algorithm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SieveOfEratosthenes implements IPrimeNumbersAlgorithm {
	
	@Override
	public List<BigInteger> generatePrimeNumbers(BigInteger providedNumber) {
	    boolean[] prime = new boolean[providedNumber.intValue() + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= providedNumber.intValue(); p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= providedNumber.intValue(); i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<BigInteger> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= providedNumber.intValue(); i++) {
	        if (prime[i]) {
	            primeNumbers.add(BigInteger.valueOf(i));
	        }
	    }
	    return primeNumbers;
	}
	
}

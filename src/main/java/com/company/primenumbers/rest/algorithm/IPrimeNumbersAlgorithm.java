package com.company.primenumbers.rest.algorithm;

import java.math.BigInteger;
import java.util.List;

public interface IPrimeNumbersAlgorithm {
	
	List<BigInteger> generatePrimeNumbers(BigInteger providedNumber);

}

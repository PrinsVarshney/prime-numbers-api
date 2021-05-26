package com.company.primenumbers.rest.test.unit.algorithm;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.company.primenumbers.rest.algorithm.Stream;

class StreamTest {

	@Test
	void testWithNumber10() {
		List<BigInteger> primes = new Stream().generatePrimeNumbers(BigInteger.valueOf(10));
		assertEquals(4, primes.size());
		assertEquals(2, primes.get(0).intValue());
		assertEquals(7, primes.get(3).intValue());
	}
	
	@Test
	void testWithNumber1() {
		List<BigInteger> primes = new Stream().generatePrimeNumbers(BigInteger.valueOf(1));
		assertEquals(0, primes.size());
	}
	
	@Test
	void testWithNumber11() {
		List<BigInteger> primes = new Stream().generatePrimeNumbers(BigInteger.valueOf(11));
		assertEquals(5, primes.size());
		assertEquals(2, primes.get(0).intValue());
		assertEquals(11, primes.get(4).intValue());
	}

}

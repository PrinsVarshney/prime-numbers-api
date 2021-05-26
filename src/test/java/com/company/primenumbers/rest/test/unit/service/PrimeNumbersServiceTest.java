package com.company.primenumbers.rest.test.unit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.company.primenumbers.rest.config.PrimeNumbersAlgorithmConfig;
import com.company.primenumbers.rest.config.PrimeNumbersAlgorithmConfig.Algorithm;
import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;
import com.company.primenumbers.rest.exception.InvalidInputException;
import com.company.primenumbers.rest.exception.LimitNotSupportedException;
import com.company.primenumbers.rest.service.PrimeNumbersService;
import com.company.primenumbers.rest.util.ApplicationConstants;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PrimeNumbersServiceTest {
	
    @InjectMocks
    PrimeNumbersService primeNumbersService;
	
    @Mock
    PrimeNumbersAlgorithmConfig primeNumbersAlgorithmConfig;
    
    static List<Algorithm> algorithms = new ArrayList<>();
    
    @BeforeAll
    public static void setUp() {
		
    	Algorithm bruteForce = new Algorithm();
		bruteForce.setName("brute-force");
		bruteForce.setClazz("com.company.primenumbers.rest.algorithm.BruteForce");
		bruteForce.setLimit("100000");
		algorithms.add(bruteForce);
		
		Algorithm optimizedBruteForce = new Algorithm();
		optimizedBruteForce.setName("optimized-brute-force");
		optimizedBruteForce.setClazz("com.company.primenumbers.rest.algorithm.OptimizedBruteForce");
		optimizedBruteForce.setLimit("100000");
		algorithms.add(optimizedBruteForce);
		
		Algorithm stream = new Algorithm();
		stream.setName("stream");
		stream.setClazz("com.company.primenumbers.rest.algorithm.Stream");
		stream.setLimit("100000");
		algorithms.add(stream);
		
		Algorithm soe = new Algorithm();
		soe.setName("sieve-of-eratosthenes");
		soe.setClazz("com.company.primenumbers.rest.algorithm.SieveOfEratosthenes");
		soe.setLimit("100000");
		algorithms.add(soe);
	}
	
	@Test
	void testGetPrimeNummbersWithBruteForceAlgorithm() {
		String input = "11";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		PrimeNumbersResponseDto dto = primeNumbersService.getPrimeNumbers(input, "brute-force");
		assertNotNull(dto);
		assertEquals(5, dto.getPrimes().size());
		assertEquals(2, dto.getPrimes().get(0).intValue());
		assertEquals(3, dto.getPrimes().get(1).intValue());
		assertEquals(11, dto.getPrimes().get(4).intValue());
	}
	
	@Test
	void testGetPrimeNummbersWithStreamAlgorithm() {
		String input = "11";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		PrimeNumbersResponseDto dto = primeNumbersService.getPrimeNumbers(input, "stream");
		assertNotNull(dto);
		assertEquals(5, dto.getPrimes().size());
		assertEquals(2, dto.getPrimes().get(0).intValue());
		assertEquals(5, dto.getPrimes().get(2).intValue());
		assertEquals(11, dto.getPrimes().get(4).intValue());
	}
	
	@Test
	void testGetPrimeNummbersWithOptimizedBruteForceAlgorithm() {
		String input = "11";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		PrimeNumbersResponseDto dto = primeNumbersService.getPrimeNumbers(input, "optimized-brute-force");
		assertNotNull(dto);
		assertEquals(5, dto.getPrimes().size());
		assertEquals(2, dto.getPrimes().get(0).intValue());
		assertEquals(7, dto.getPrimes().get(3).intValue());
		assertEquals(11, dto.getPrimes().get(4).intValue());
	}
	
	@Test
	void testGetPrimeNummbersWithSieveOfEratosthenesAlgorithm() {
		String input = "11";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		PrimeNumbersResponseDto dto = primeNumbersService.getPrimeNumbers(input, "sieve-of-eratosthenes");
		assertNotNull(dto);
		assertEquals(5, dto.getPrimes().size());
		assertEquals(2, dto.getPrimes().get(0).intValue());
		assertEquals(3, dto.getPrimes().get(1).intValue());
		assertEquals(5, dto.getPrimes().get(2).intValue());
		assertEquals(7, dto.getPrimes().get(3).intValue());
		assertEquals(11, dto.getPrimes().get(4).intValue());
	}
	
	@Test
	void testGetPrimeNummbersWithInvalidAlgorithm() {
		String input = "11";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		Exception exception = assertThrows(InvalidInputException.class, () ->
			primeNumbersService.getPrimeNumbers(input, "unknown")
	    );
		assertEquals(ApplicationConstants.INVALID_PROVIDED_ALGO_MSG, exception.getMessage());
	}
	
	@Test
	void testGetPrimeNummbersWithInvalidInput() {
		String input = "11D";
		Exception exception = assertThrows(InvalidInputException.class, () -> 
			primeNumbersService.getPrimeNumbers(input, "Stream")
	    );
		assertEquals(ApplicationConstants.INVALID_PROVIDED_NUMBER_MSG, exception.getMessage());
	}
	
	@Test
	void testGetPrimeNummbersWithInvalidLimit() {
		String input = "1111111111111111111111";
		when(primeNumbersAlgorithmConfig.getAllAlgorithms()).thenReturn(algorithms);
		Exception exception = assertThrows(LimitNotSupportedException.class, () -> 
			primeNumbersService.getPrimeNumbers(input, "sieve-of-eratosthenes")
	    );
		assertEquals(ApplicationConstants.LIMIT_NOT_SUPPORTED_MSG, exception.getMessage());
	}
	
}

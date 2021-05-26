package com.company.primenumbers.rest.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.company.primenumbers.rest.algorithm.IPrimeNumbersAlgorithm;
import com.company.primenumbers.rest.config.PrimeNumbersAlgorithmConfig;
import com.company.primenumbers.rest.config.PrimeNumbersAlgorithmConfig.Algorithm;
import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;
import com.company.primenumbers.rest.exception.InvalidInputException;
import com.company.primenumbers.rest.exception.LimitNotSupportedException;
import com.company.primenumbers.rest.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrimeNumbersService implements IPrimeNumbersService { 
	
	@Autowired
	PrimeNumbersAlgorithmConfig primeNumbersAlgorithmConfig;
	
	@Cacheable(value = "primes-cache", key ="#providedNumber" )
	@Override
	public PrimeNumbersResponseDto getPrimeNumbers(String providedNumber, String providedAlgorithm) {
		
		// verify inputs
		BigInteger primesUptoNumber = verifyProvidedNumber(providedNumber);
		providedAlgorithm = verifyProvidedAlgorithm(providedAlgorithm);
		
		// get configured algorithm
		Algorithm algorithm = getAlgorithmConfig(providedAlgorithm);
		
		// validate limit
		validateLimit(primesUptoNumber, algorithm.getLimit());
		
		// get algorithm instance
		IPrimeNumbersAlgorithm algorithmInstance = getAlgorithmInstance(algorithm.getClazz());
		
		// get primes
		List<BigInteger> primes = algorithmInstance.generatePrimeNumbers(primesUptoNumber);
		
		return new PrimeNumbersResponseDto(primesUptoNumber, primes);
	}
	
	private BigInteger verifyProvidedNumber(String providedNumber) {
		try {
			return new BigInteger(providedNumber);
		} catch (NumberFormatException e) {
			log.error("Provided number is not a valid number : {}", providedNumber);
			throw new InvalidInputException(ApplicationConstants.INVALID_PROVIDED_NUMBER_MSG);
		}
	}
	
	private String verifyProvidedAlgorithm(String providedAlgorithm) {
		if(providedAlgorithm == null || providedAlgorithm.trim().isEmpty()) { 
			providedAlgorithm = primeNumbersAlgorithmConfig.getDefaultAlgorithm();
		}
		return providedAlgorithm;
	}
	
	private Algorithm getAlgorithmConfig(String providedAlgorithm) {
		return primeNumbersAlgorithmConfig.getAllAlgorithms().stream()
				.filter(algorithm -> providedAlgorithm.equals(algorithm.getName()))
				.findFirst()
				.orElseThrow(() -> new InvalidInputException(ApplicationConstants.INVALID_PROVIDED_ALGO_MSG));
	}
	
	private void validateLimit(BigInteger primesUptoNumber, String limit) {
		try {
			BigInteger biLimit = new BigInteger(limit);
			if(primesUptoNumber.compareTo(biLimit) > 0) {
				log.error("Algorithm does not support limit, provided-number : {}, algorithm-limit : {}", primesUptoNumber.toString(), limit);
				throw new LimitNotSupportedException(ApplicationConstants.LIMIT_NOT_SUPPORTED_MSG);
			}
		} catch (NumberFormatException e) {
			log.error("Configured limit is not a valid number : {}", limit);
		}
	}
	
	private IPrimeNumbersAlgorithm getAlgorithmInstance(String className) {
		IPrimeNumbersAlgorithm algorithm = null;
		try {
			Class<?> algorithmClass = Class.forName(className);
			algorithm = (IPrimeNumbersAlgorithm) algorithmClass.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			log.error("Invalid provided-algorithm : {}", className);
			throw new InvalidInputException(ApplicationConstants.INVALID_PROVIDED_ALGO_MSG);
		}
		log.debug("Algorithm class : {}", algorithm.getClass());
		return algorithm;
	}
	
}

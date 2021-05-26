package com.company.primenumbers.rest.controller;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;
import com.company.primenumbers.rest.service.IPrimeNumbersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("prime-numbers-api/v1")
@Tag(name = "Prime Numbers Endpoints", description = "RESTful API Endpoints providing prime numbers.")
public class PrimeNumbersController {
    
    @Autowired
    private IPrimeNumbersService primeNumbersService;

    @GetMapping("primes/{provided-number}")
    @Operation(summary = "Provides all prime numbers upto and including the number provided.", 
    		   tags = { "Prime Numbers API." })
	public ResponseEntity<PrimeNumbersResponseDto> getPrimeNumbers(
			@PathVariable(value = "provided-number", required = true) final String providedNumber,
			@RequestParam(value = "provided-algorithm", required = false) final String providedAlgorithm
			) {
    			Instant start = Instant.now();
				log.debug("Received request, provided-number : {}, provided-algorithm : {}", providedNumber, providedAlgorithm);
				PrimeNumbersResponseDto  primeNumbersResponseDto = primeNumbersService.getPrimeNumbers(providedNumber, providedAlgorithm);
				Instant end = Instant.now();
				log.debug("Request processing turnaround time : {} ms, for provided-number : {}", Duration.between(start, end).toMillis(), providedNumber);
				return ResponseEntity.ok().body(primeNumbersResponseDto);
    }

}


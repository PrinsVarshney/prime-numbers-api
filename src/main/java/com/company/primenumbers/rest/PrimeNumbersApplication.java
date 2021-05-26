package com.company.primenumbers.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PrimeNumbersApplication {

	public static void main(String[] args) { //NOSONAR 
		SpringApplication.run(PrimeNumbersApplication.class, args);
	}
	
}

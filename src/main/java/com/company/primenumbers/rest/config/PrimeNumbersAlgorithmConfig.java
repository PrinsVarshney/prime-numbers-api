package com.company.primenumbers.rest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("prime-numbers-algorithms")
public class PrimeNumbersAlgorithmConfig {
	
	private String defaultAlgorithm;
	private List<Algorithm> allAlgorithms = new ArrayList<>();
	
	@Getter
	@Setter
	public static class Algorithm {
		private String name;
		private String clazz;
		private String limit;
	}

}

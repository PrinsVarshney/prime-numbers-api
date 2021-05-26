package com.company.primenumbers.rest.test.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.primenumbers.rest.PrimeNumbersApplication;
import com.company.primenumbers.rest.util.ApplicationConstants;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrimeNumbersApplication.class)
@AutoConfigureMockMvc
class PrimeNumbersApplicationIntegrationTest {
	
	private static final String API_URL = "/prime-numbers-api/v1/primes/";
	private static final String INITIALS = "$.initial";
	private static final String PRIMES = "$.primes";
	private static final String PRIMES_1 = PRIMES + ".[0]";
	private static final String PRIMES_2 = PRIMES + ".[1]";
	private static final String PRIMES_3 = PRIMES + ".[2]";
	private static final String PRIMES_4 = PRIMES + ".[3]";
	private static final String PRIMES_5 = PRIMES + ".[4]";
	private static final String ERROR = "$.error";
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
    void testPrimeNumbersSuccessWithDefaultAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "2"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(2)))
        		.andExpect(jsonPath(PRIMES, hasSize(1)))
        		.andExpect(jsonPath(PRIMES_1, is(2)));
    }
	
	@Test
    void testPrimeNumbersSuccessWithDefaultAlgorithmAndJSONMedia() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "3")
    			.accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(3)))
        		.andExpect(jsonPath(PRIMES, hasSize(2)))
        		.andExpect(jsonPath(PRIMES_1, is(2)))
        		.andExpect(jsonPath(PRIMES_2, is(3)));
    }
	
	@Test
    void testPrimeNumbersSuccessWithDefaultAlgorithmAndXMLMedia() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "4")
    			.accept(MediaType.APPLICATION_XML))
    			.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
        		.andExpect(content().string("<PrimeNumbersResponseDto><initial>4</initial><primes><primes>2</primes><primes>3</primes></primes></PrimeNumbersResponseDto>"));
    }
	
	@Test
    void testPrimeNumbersSuccessWithBruteForceAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "5?provided-algorithm=brute-force"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(5)))
        		.andExpect(jsonPath(PRIMES, hasSize(3)))
        		.andExpect(jsonPath(PRIMES_1, is(2)))
        		.andExpect(jsonPath(PRIMES_2, is(3)))
        		.andExpect(jsonPath(PRIMES_3, is(5)));
    }
	
	
	@Test
    void testPrimeNumbersSuccessWithOptimizedBruteForceAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "6?provided-algorithm=optimized-brute-force"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(6)))
        		.andExpect(jsonPath(PRIMES, hasSize(3)))
        		.andExpect(jsonPath(PRIMES_1, is(2)))
        		.andExpect(jsonPath(PRIMES_2, is(3)))
        		.andExpect(jsonPath(PRIMES_3, is(5)));
    }
	
	
	@Test
    void testPrimeNumbersSuccessWithStreamAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "7?provided-algorithm=stream"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(7)))
        		.andExpect(jsonPath(PRIMES, hasSize(4)))
        		.andExpect(jsonPath(PRIMES_1, is(2)))
        		.andExpect(jsonPath(PRIMES_2, is(3)))
        		.andExpect(jsonPath(PRIMES_3, is(5)))
        		.andExpect(jsonPath(PRIMES_4, is(7)));
    }
	
	@Test
    void testPrimeNumbersSuccessWithSieveOfEratosthenesAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "11?provided-algorithm=sieve-of-eratosthenes"))
        		.andExpect(status().isOk())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(INITIALS, is(11)))
        		.andExpect(jsonPath(PRIMES, hasSize(5)))
        		.andExpect(jsonPath(PRIMES_1, is(2)))
        		.andExpect(jsonPath(PRIMES_2, is(3)))
        		.andExpect(jsonPath(PRIMES_3, is(5)))
        		.andExpect(jsonPath(PRIMES_4, is(7)))
        		.andExpect(jsonPath(PRIMES_5, is(11)));
    }
	
	@Test
    void testPrimeNumbersSuccessWithBlankAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "8?provided-algorithm= "))
		    	.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath(INITIALS, is(8)))
				.andExpect(jsonPath(PRIMES, hasSize(4)))
				.andExpect(jsonPath(PRIMES_1, is(2)))
				.andExpect(jsonPath(PRIMES_2, is(3)))
				.andExpect(jsonPath(PRIMES_3, is(5)))
				.andExpect(jsonPath(PRIMES_4, is(7)));
    }
	
	@Test
    void testPrimeNumbersSuccessWithInvalidAlgorithmParameter() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "9?provided-algorithm-invalid=null"))
		    	.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath(INITIALS, is(9)))
				.andExpect(jsonPath(PRIMES, hasSize(4)))
				.andExpect(jsonPath(PRIMES_1, is(2)))
				.andExpect(jsonPath(PRIMES_2, is(3)))
				.andExpect(jsonPath(PRIMES_3, is(5)))
				.andExpect(jsonPath(PRIMES_4, is(7)));
    }
	
	@Test
    void testPrimeNumbersFailureWithUnknownAlgorithm() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "10?provided-algorithm=unknown"))
        		.andExpect(status().isBadRequest())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(ERROR, is(ApplicationConstants.INVALID_PROVIDED_ALGO_MSG)));
    }
	
	@Test
    void testPrimeNumbersFailureWithDecimalNumber() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "10.1"))
        		.andExpect(status().isBadRequest())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(ERROR, is(ApplicationConstants.INVALID_PROVIDED_NUMBER_MSG)));
    }
	
	@Test
    void testPrimeNumbersFailureWithString() throws Exception { 
    	this.mockMvc.perform(get(API_URL + "10String"))
        		.andExpect(status().isBadRequest())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(ERROR, is(ApplicationConstants.INVALID_PROVIDED_NUMBER_MSG)));
    }
	
	@Test
    void testPrimeNumbersFailureWithBlank() throws Exception { 
    	this.mockMvc.perform(get(API_URL + " "))
        		.andExpect(status().isBadRequest())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(ERROR, is(ApplicationConstants.INVALID_PROVIDED_NUMBER_MSG)));
    }
	
	@Test
    void testPrimeNumbersFailureWithInvalidLimit() throws Exception { 
    	this.mockMvc.perform(get(API_URL + Long.MAX_VALUE +"?provided-algorithm=brute-force"))
        		.andExpect(status().isInternalServerError())
        		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath(ERROR, is(ApplicationConstants.LIMIT_NOT_SUPPORTED_MSG)));
    }

}

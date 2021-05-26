package com.company.primenumbers.rest.test.unit.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.primenumbers.rest.PrimeNumbersApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrimeNumbersApplication.class)
class OpenAPIConfigTest {
	
	@Test
	void contextLoads() {
	}

}

package com.company.primenumbers.rest.test.unit.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;

class PrimeNumbersResponseDtoTest {

	@Test
	void testInitialAndPrimes() {
		BigInteger input = BigInteger.valueOf(10);
		PrimeNumbersResponseDto dto = new PrimeNumbersResponseDto(input, null);
		assertEquals(input, dto.getInitial());
		assertNull(dto.getPrimes());
	}

}

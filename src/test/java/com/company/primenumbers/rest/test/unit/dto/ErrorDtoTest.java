package com.company.primenumbers.rest.test.unit.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.company.primenumbers.rest.dto.ErrorDto;

class ErrorDtoTest {

	@Test
	void testError() {
		String input = "Error message";
		ErrorDto dto = new ErrorDto(input);
		assertEquals(input, dto.getError());
	}

}

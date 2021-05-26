package com.company.primenumbers.rest.test.unit.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.company.primenumbers.rest.controller.PrimeNumbersController;
import com.company.primenumbers.rest.dto.PrimeNumbersResponseDto;
import com.company.primenumbers.rest.service.IPrimeNumbersService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PrimeNumbersControllerTest {
	
    @InjectMocks
    PrimeNumbersController primeNumbersController;
     
    @Mock
    IPrimeNumbersService primeNumbersService;
    
	@Test
    void testGetPrimeNumbersSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        BigInteger input = BigInteger.valueOf(10);
        PrimeNumbersResponseDto dto = new PrimeNumbersResponseDto(input, null);
        when(primeNumbersService.getPrimeNumbers(any(String.class), any(String.class))).thenReturn(dto);
        ResponseEntity<PrimeNumbersResponseDto> responseEntity = primeNumbersController.getPrimeNumbers(input.toString(), "brute-force");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getInitial()).isEqualTo(input);
    }

}

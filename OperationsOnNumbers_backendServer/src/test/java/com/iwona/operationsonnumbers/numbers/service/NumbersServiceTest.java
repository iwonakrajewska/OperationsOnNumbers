package com.iwona.operationsonnumbers.numbers.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iwona.operationsonnumbers.numbers.response.SingleNumberResponse;
import com.iwona.operationsonnumbers.numbers.rules.NumbersValidator;

public class NumbersServiceTest {

	@InjectMocks
	private NumbersService numbersService;
	@Mock
	private NumbersValidator numbersValidator;
	@Mock
	private SingleNumberResponse response;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void checkAddition(){
		SingleNumberResponse response = numbersService.addNumbers("1", "2");
		assertEquals("3",response.getNumberText());
	}

	@Test
	public void checkAdditionDouble(){
		SingleNumberResponse response = numbersService.addNumbers("1.5", "2.2");
		assertEquals("3.7",response.getNumberText());
	}

	@Test
	public void checkSubtract(){
		SingleNumberResponse response = numbersService.subtractNumbers("3.4", "2");
		assertEquals("1.4",response.getNumberText());
	}


	@Test
	public void checkMultiply(){
		SingleNumberResponse response = numbersService.multiplyNumbers("3.4", "2");
		assertEquals("6.8",response.getNumberText());
	}

	@Test
	public void checkDivide(){
		SingleNumberResponse response = numbersService.divideNumbers("3.4", "2");
		assertEquals("1.70",response.getNumberText());
	}

}

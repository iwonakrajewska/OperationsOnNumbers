package com.iwona.operationsonnumbers.numbers.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iwona.operationsonnumbers.numbers.response.AbstractResponse;
import com.iwona.operationsonnumbers.numbers.response.SingleNumberResponse;

public class NumbersValidatorTest {

	@InjectMocks
	private NumbersValidator numbersValidator;

	private AbstractResponse response;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void checkAdditionValidator() {
		response = new SingleNumberResponse();
		numbersValidator.validateAddition("1", "2", response);
		assertEquals(0, response.getErrorMessages().size());
	}

	@Test
	public void checkAdditionValidatorIncorrectText() {
		response = new SingleNumberResponse();
		numbersValidator.validateAddition(null, "", response);
		assertEquals(2, response.getErrorMessages().size());
	}

	@Test
	public void checkAdditionValidatorIncorrectNumbers() {
		response = new SingleNumberResponse();
		numbersValidator.validateAddition("-1234567890.1234567890", " ", response);
		assertEquals(1, response.getErrorMessages().size());
	}

	@Test
	public void checkAdditionValidatorCorrectNumbers() {
		response = new SingleNumberResponse();
		numbersValidator.validateAddition("-1234567890.1234567890", "+1234567890.1234567890", response);
		assertEquals(0, response.getErrorMessages().size());
	}

	@Test
	public void checkSubstractionValidatorEmptyText() {
		response = new SingleNumberResponse();
		numbersValidator.validateSubtraction(null, null, response);
		assertEquals(2, response.getErrorMessages().size());
	}

	@Test
	public void checkSubstractionValidatorIncorrectText() {
		response = new SingleNumberResponse();
		numbersValidator.validateSubtraction("1,2", " ", response);
		assertEquals(2, response.getErrorMessages().size());
	}

	@Test
	public void checkMultiplicationValidatorIncorrectText() {
		response = new SingleNumberResponse();
		numbersValidator.validateMultiplication("", " ", response);
		assertEquals(2, response.getErrorMessages().size());
	}

	@Test
	public void checkDivisionValidatorIncorrectText() {
		response = new SingleNumberResponse();
		numbersValidator.validateDivision(" ", " ", response);
		assertEquals(2, response.getErrorMessages().size());
	}

	@Test
	public void checkDivisionValidatorZeroText() {
		response = new SingleNumberResponse();
		numbersValidator.validateDivision("0.0", "0.0", response);
		assertEquals(1, response.getErrorMessages().size());
	}

}

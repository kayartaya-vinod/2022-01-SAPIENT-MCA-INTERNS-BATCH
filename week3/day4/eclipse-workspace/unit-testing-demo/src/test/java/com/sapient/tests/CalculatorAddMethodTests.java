package com.sapient.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.InputMismatchException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sapient.Calculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CalculatorAddMethodTests {
	
	Calculator calc;
	
	@BeforeAll
	static void beforeAll() {
		log.trace("CalculatorAddMethodTests.beforeAll() called");
	}
	
	@AfterAll
	static void afterAll() {
		log.trace("CalculatorAddMethodTests.afterAll() called");
	}
	
	@BeforeEach
	void setup() {
		log.trace("CalculatorAddMethodTests.setup() called");
		calc = new Calculator();
	}
	
	@AfterEach
	void tearDown() {
		// do some clean up after each test case execution
		log.trace("CalculatorAddMethodTests.tearDown() called");
	}
	
	@DisplayName("Should add two numbers")
	@Test
	void shouldAddTwoNumbers() {
		log.trace("CalculatorAddMethodTests.shouldAddTwoNumbers() called");
		String input = "10,20";
		int expected = 30;
		int actual = calc.sum(input);
		
		assertEquals(expected, actual);
	}

	@Test
	void shouldAddMoreThanTwoNumbers() {
		log.trace("CalculatorAddMethodTests.shouldAddMoreThanTwoNumbers() called");
		String input = "10, 90, 50, 30, 20";
		int expected = 200;
		int actual = calc.sum(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void shouldAddNegativeNumbers() {
		log.trace("CalculatorAddMethodTests.shouldAddNegativeNumbers() called");

		String input = "-10, -20, -30";
		assertEquals(-60, calc.sum(input));
	}
	
	
	@Disabled("Skipping this test since it is almost a duplicate of another")
	@Test
	void shouldAddCombinationOfPositiveAndNegativeNumbers() {
		log.trace("CalculatorAddMethodTests.shouldAddCombinationOfPositiveAndNegativeNumbers() called");

		String input =  "-10, -20, 30, 2";
		assertEquals(2, calc.sum(input));
	}
	
	@Test
	void shouldThrowNullPointerException() {
		log.trace("CalculatorAddMethodTests.shouldThrowNullPointerException() called");

		assertThrows(NullPointerException.class, ()->{
			calc.sum(null);
		});
	}
	
	@DisplayName("InputMismatchException is expected from this test case")
	@Test
	void shouldThrowInputMismatchException() {
		log.trace("CalculatorAddMethodTests.shouldThrowInputMismatchException() called");

//		assertThrows(InputMismatchException.class, ()->{
//			calc.sum("10, 20");
//		});
		
		try {
			calc.sum("10, 20, vinod");
			// if the control reaches this line, then the test is failed
			fail("Expected InputMismatchException was not thrown!");
		}
		catch(InputMismatchException ex) {
			// test passed; if control reaches here!
		}
	}
	

}










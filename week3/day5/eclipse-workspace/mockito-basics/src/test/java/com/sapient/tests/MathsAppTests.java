package com.sapient.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.sapient.app.MathsApp;
import com.sapient.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MathsAppTests {

	// we are mocking (creating a stub, a fake implementation) since the actual
	// Implementation of the service class is not ready yet or we would like to test
	// our code in isolation. Mockito is the one which creates this fake object.
	@Mock
	CalculatorService service;

	// Mockito assigns the dependency in MathsApp object using the reflection api.
	@InjectMocks
	private MathsApp app = new MathsApp();

	@BeforeEach
	void setup() {

		// we are teaching Mockito as what to return when it encounters a specific
		// method call in side the test subject
		Mockito.when(service.add(0, 10)).thenReturn(10.0);
		Mockito.when(service.add(10, 20)).thenReturn(30.0);
	}

	@Test
	void shouldAddTwoNumbers() {
		String input = "10, 20";
		double expected = 30.0;
		double actual = app.addNumbers(input);
		assertEquals(expected, actual);
	}

	@Test
	void shouldAddMoreThanTwoNumbers() {
		Mockito.when(service.add(30, 30)).thenReturn(60.0);
		Mockito.when(service.add(60, 40)).thenReturn(100.0);
		Mockito.when(service.add(100, 50)).thenReturn(150.0);
		Mockito.when(service.add(160, 60)).thenReturn(210.0);
		
		String input = "10, 20, 30, 40, 50";
		double expected = 150.0;
		double actual = app.addNumbers(input);
		assertEquals(expected, actual);
	}

	
	@Test 
	void shouldDivideValidInputs(){
		String input = "10,2";
		Mockito.when(service.divide(10, 2)).thenReturn(5.0);
		assertEquals(5.0, app.divide(input));
	}
	
	@Test
	void shouldThrowArithmeticException() {
		Mockito.when(service.divide(10, 0)).thenThrow(ArithmeticException.class);
		
		assertThrows(ArithmeticException.class, ()->{
			app.divide("10, 0");
		});
	}
	
	@Test
	void shouldThrowInputMismatchException() {
		
		assertThrows(InputMismatchException.class, ()->{
			app.divide("10, 12, 34");
		});
	}

	@Test 
	void shouldSubtractValidInputs(){
		String input = "10,2";
		Mockito.when(service.subtract(10, 2)).thenReturn(8.0);
		assertEquals(8.0, app.subtract(input));
	}
	
}

















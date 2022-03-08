package com.sapient.bdd;

import static org.junit.Assert.assertEquals;

import com.sapient.FactorialGenerator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FactorialGeneratorTestSteps {

	FactorialGenerator fg;
	Long actual;
	
	// this is equivalent of @BeforeEach
	@Given("I have a factorial generator")
	public void i_have_a_factorial_generator() {
	    fg = new FactorialGenerator();
	}

	@When("I pass {int} as parameter")
	public void i_pass_as_parameter(Integer input) {
	    actual = fg.getFactorial(input);
	}

	@Then("I should get {long} as factorial")
	public void i_should_get_as_factorial(Long expected) {
		assertEquals(expected, actual);
	}

}

package com.sapient.junit;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/factorial.feature", plugin = { "pretty" }, glue = { "com.sapient.bdd" })
public class FactorialGeneratorTest {

}

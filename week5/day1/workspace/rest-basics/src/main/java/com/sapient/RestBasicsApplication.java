package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The following annotation is a combination of these annotations:
// @Configuration, @ComponentScan, @EnableWebMvc, @EnableTransactionManagement, @PropertySource
@SpringBootApplication
public class RestBasicsApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestBasicsApplication.class, args);
	}

}

package com.sapient;

public class FactorialGenerator {
	
	public long getFactorial(int num) {
		
		long fact = 1;
		
		while(num>1) {
			fact *= num--;
		}
		
		return fact;
	}
}

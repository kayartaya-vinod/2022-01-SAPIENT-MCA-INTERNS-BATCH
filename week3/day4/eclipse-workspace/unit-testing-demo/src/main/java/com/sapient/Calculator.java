package com.sapient;

import java.util.InputMismatchException;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides basic maths operations like add, sine etc
 * 
 * 
 * @author Vinod Kumar <vinod@vinod.co>
 */
@Slf4j
public class Calculator {

	/**
	 * This function adds all integers in the given input string, assuming that the
	 * numbers are separated using a comma.
	 * 
	 * @param text - comma separated integers in a string
	 * @return sum of all integers in the string
	 * @throws InputMismatchException when the input has non-numeric values
	 * @throws NullPointerException   when the input is null
	 */
	public int sum(String text) throws InputMismatchException, NullPointerException {
		log.trace("input is \"" + text +"\"");
		
		String[] arr = text.split(",");
		int total = 0;
		for (String num : arr) {
			try {
				total += Integer.parseInt(num.strip());
			} catch (NumberFormatException e) {
				throw new InputMismatchException(e.getMessage());
			}
		}

		return total;
	}

}

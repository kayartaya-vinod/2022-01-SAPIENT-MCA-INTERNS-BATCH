package com.sapient.programs;

import java.util.Arrays;

public class ExceptionDemo3 {
    public static void main(String[] args) {

        try {
            String input1 = args[0];
            String input2 = args[1];
            int num = Integer.parseInt(input1);
            int den = Integer.parseInt(input2);
            int q = num / den;
            System.out.println("quotient of " + num + " divided by " + den + " is " + q);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Expected 2 integers, but got: " + Arrays.toString(args));
        } catch (ArithmeticException e) {
            System.err.println("You cannot divide by zero");
        } catch (Exception e) {
            System.out.println("OOPS! There was an error - " + e.getMessage());
        }
        // program resumes even after an exception occurs

        System.out.println("This is the end of the app.");
    }
}

// java -cp target/classes com.sapient.programs.ExceptionDemo1
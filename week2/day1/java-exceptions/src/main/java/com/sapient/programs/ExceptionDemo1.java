package com.sapient.programs;

public class ExceptionDemo1 {
    public static void main(String[] args) {

        String input1 = args[0]; // "123"
        String input2 = args[1]; // JRE identifies the issue and throws an object of class
                                 // ArrayIndexOutOfBoundsException

        int num = Integer.parseInt(input1); // "123" --> 123; // parseInt identifies the issue, throws an object of
                                            // class NumberFormatException
        int den = Integer.parseInt(input2);

        int q = num / den; // JRE identifies the issue, and throws an object of class ArithmeticException

        System.out.println("quotient of " + num + " divided by " + den + " is " + q);
        System.out.println("This is the end of the app.");
    }
}

// java -cp target/classes com.sapient.programs.ExceptionDemo1
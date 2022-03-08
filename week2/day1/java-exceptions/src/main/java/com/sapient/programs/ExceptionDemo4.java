package com.sapient.programs;

import java.util.Arrays;

public class ExceptionDemo4 {
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
            // return;
            // System.exit(0);
        } finally {
            // use of finally block is limited to close certain resources, if not done may
            // cause resource leak

            // this is executed after when
            // 1. there is an exception and a corresponding catch block
            // 2. there is an exception and no catch block to handle (program will break)
            // 3. there is no exception thrown
            // 4. there is a return statement in the try block or catch block
            System.out.println("This is from finally block");

            // the only time this block is not reached when System.exit(n) is called
        }

        System.out.println("This is the end of the app.");
    }
}

// java -cp target/classes com.sapient.programs.ExceptionDemo1
package com.sapient.programs;

public class CommandLineArgsDemo {

    public static void main(String[] args) {
        System.out.printf("There are %d arguments%n", args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d] = %s%n", i, args[i]);
        }
    }
}

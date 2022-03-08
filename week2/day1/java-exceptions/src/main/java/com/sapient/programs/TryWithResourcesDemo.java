package com.sapient.programs;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        String filename = "pom.xml";

        // You can delcare and initialize variables of "AutoCloseable" types
        // i.e, the objects have a close() function in them.
        // This is called try-with-resources block
        try (FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);) {

            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } // in.close() and reader.close() will be called here automatically
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.sapient.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFilesDemo {

    public static void main(String[] args) {

        String filename = "pom.xml";
        FileReader reader = null;
        BufferedReader in = null;
        try {
            reader = new FileReader(filename);
            in = new BufferedReader(reader);
            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

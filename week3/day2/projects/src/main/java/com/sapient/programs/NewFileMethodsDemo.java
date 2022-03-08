package com.sapient.programs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class NewFileMethodsDemo {

	public static void main(String[] args) throws IOException {
		String filename = "src/main/java/com/sapient/entity/Book.java";
		File file = new File(filename);
		
		String text = Files.readString(file.toPath());
		
		System.out.println(text);
		
		text = "my name is Vinod Kumar.\nI live in Bangalore.\n\nI am a freelance software trainer.";
		
		filename = "vinod.txt";
		file = new File(filename);
		
		Files.writeString(file.toPath(), text, StandardOpenOption.APPEND);
		
	}

}

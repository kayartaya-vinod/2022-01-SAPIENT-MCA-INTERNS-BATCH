package com.sapient.programs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ParallelStreamDemo {

	public static void main(String[] args) throws IOException {

		String filename = "src/main/java/com/sapient/programs/CollectorsDemo.java";
		File file = new File(filename);
		
		if(!file.exists()) {
			throw new RuntimeException("File not found - " + filename);
		}
		
		try (Stream<String> lines = Files.lines(file.toPath())) {
			// lines.forEach(System.out::println);
			lines.parallel().forEach(System.out::println);
		}
		
	}

}

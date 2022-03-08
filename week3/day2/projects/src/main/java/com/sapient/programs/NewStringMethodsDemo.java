package com.sapient.programs;

import java.util.Arrays;
import java.util.List;

public class NewStringMethodsDemo {

	public static void main(String[] args) {
		List<String> namesList = Arrays.asList("Vinod", "Shyam", "John", "Jane");
		
		// java 1.8
		String names = String.join(", ", namesList);
		System.out.println(names);
		

		// java 9
		String text = "My name is vinod";
		text.chars()
			.forEach(System.out::println);
		
		
		// java 11
		// 1. isBlank
		String str1 = "     ";
		System.out.println("str1.isBlank() is " + str1.isBlank());
		System.out.println("str1.isEmpty() is " + str1.isEmpty()); // 1.6
		
		// 2. lines()
		String str2 = "my\nname\nis\nvinod\n";
		
		str2.lines().forEach(System.out::println);
		
		// 3. strip, stripLeading, stripTrailing
		String str3 = "       VINOD      KUMAR     ";
		
		System.out.println(">>>" + str3 + "<<<");
		System.out.println(">>>" + str3.strip() + "<<<");
		System.out.println(">>>" + str3.stripLeading() + "<<<");
		System.out.println(">>>" + str3.stripTrailing() + "<<<");
		
	}

}

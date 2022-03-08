package com.sapient.utils;

import java.util.Scanner;

@SuppressWarnings("resource")
public final class KeyboardUtil {

	private KeyboardUtil() {
	}

	public static String getString(String message) {
		System.out.print(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}

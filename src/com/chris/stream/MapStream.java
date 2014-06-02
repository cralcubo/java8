package com.chris.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStream {

	public static void main(String... strings) {
		// Word list return number of characters
		List<String> words = Arrays.asList("casa", "puerta", "Bolivia");
		List<Integer> chars = words.stream().map(String::length)
				.collect(Collectors.toList());
		System.out.println("Nr characters: " + chars);

		// Square of numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> squares = numbers.stream().map(number -> number * number)
				.collect(Collectors.toList());
		System.out.println("Squares: " + squares);
	}

}

package com.chris.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {
	
	public static void main(String...strings ){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//Square of numbers using reduce
		int sumOfsquare = numbers.stream().map(n-> n * n).reduce(0 , (a,b) -> a + b);
		System.out.println("The sum of all squares is: " + sumOfsquare);
		
		//Sum of numbers
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum of all numbers: " + sum);
		
		//Max of all numbers
		int max = numbers.stream().reduce(0, Math::max);
		System.out.println("Max of all numbers: " + max);
	}

}

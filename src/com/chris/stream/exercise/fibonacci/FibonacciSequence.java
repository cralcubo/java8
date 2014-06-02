package com.chris.stream.exercise.fibonacci;

import java.util.stream.Stream;

public class FibonacciSequence {

	public static void main(String[] args) {
		int[] initArray = {0,1};
		Stream.iterate(initArray, n -> new int[]{n[1], n[0] + n[1]}).limit(20).forEach(n -> System.out.println(n[0] +" " + n[1]));

	}

}

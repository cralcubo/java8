package com.chris.stream.partitioning;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PrimeCalculatorTest {
	private PrimeCalculator calculator;
	
	@Before
	public void setUp(){
		calculator = new PrimeCalculator();
	}
	
	@Test
	public void testCalculator(){
		int number = 20;
		
		Map<Boolean, List<Integer>> primes = calculator.partitionPrimes(number);
		
		//Lets just print to see the expected results
		System.out.println(primes);
	}

}

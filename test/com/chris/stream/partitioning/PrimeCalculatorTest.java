package com.chris.stream.partitioning;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.chris.stream.partitioning.prime.numbers.PrimeCalculator;

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
	
	@Test
	public void testCalculator_CustomCollector(){
		int number = 20;
		Map<Boolean, List<Integer>> primes = calculator.partitionPrimes_CustomCollector(number);
		
		//Checking if we have primes
		System.out.println(primes);
	}

}

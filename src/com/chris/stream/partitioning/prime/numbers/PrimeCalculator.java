package com.chris.stream.partitioning.prime.numbers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.chris.stream.collectors.PrimeNumbersCollector;

public class PrimeCalculator {
	
	public Map<Boolean, List<Integer>> partitionPrimes(int number){
		return IntStream.rangeClosed(2, number).boxed().collect(Collectors.partitioningBy(n -> isPrime(n)));
	}
	
	private boolean isPrime(int candidate){
		return IntStream.range(2, candidate).noneMatch(n -> candidate % n == 0);
	}
	
	public Map<Boolean, List<Integer>> partitionPrimes_CustomCollector(int number){
		return IntStream.rangeClosed(2, number).boxed().collect(new PrimeNumbersCollector());
	}

}

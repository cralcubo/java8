package com.chris.stream.partitioning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculator {
	
	public Map<Boolean, List<Integer>> partitionPrimes(int number){
		return IntStream.rangeClosed(2, number).boxed().collect(Collectors.partitioningBy(n -> isPrime(n)));
	}
	
	private boolean isPrime(int candidate){
		return IntStream.range(2, candidate).noneMatch(n -> candidate % n == 0);
	}

}

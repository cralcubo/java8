package com.chris.stream.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
	
	/**
	 * Method that returns a function that when invoked
	 * creates the accumulator.
	 * 
	 */
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		Map<Boolean, List<Integer>> map = new HashMap<>();
		map.put(true, new ArrayList<>());
		map.put(false, new ArrayList<>());
		return () -> map;
	}
	
	/**
	 * Accumulator:
	 * Method that contains the logic defining how the elements of
	 * the Stream have to be collected. 
	 * 
	 */
	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
			acc.get(isPrime(acc.get(true), candidate)).add(candidate);
		};
	}
	
	/**
	 * Making the collector to work in Parallel.
	 * (If possible)
	 * (NOT REALY USED IN THE PRIMES EXAMPLE THOUGH)
	 */
	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) ->{
			map1.get(true).addAll(map2.get(true));
			map1.get(false).addAll(map2.get(false));
			
			return map1;
		};
	}
	
	/**
	 * Finisher:
	 * Returns the identity function.
	 * 
	 */
	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}
	
	/**
	 * This Collector is neither UNORDERED or CONCURRENT, because 
	 * prime numbers are discovered in sequence.
	 * 
	 */
	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
		
	}
	
	private boolean isPrime(List<Integer> primes, Integer candidate) {
		return primes.stream().noneMatch(i -> candidate % i == 0);
	}	

}

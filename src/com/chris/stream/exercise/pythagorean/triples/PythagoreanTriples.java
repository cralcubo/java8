package com.chris.stream.exercise.pythagorean.triples;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
	
	public static void main(String ...strings ){
		Stream<int[]> triples = IntStream.range(1, 100).boxed()
				.flatMap(a -> IntStream.range(a, 100)
						.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
						.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)} ));
		
		triples.limit(5).forEach(t -> System.out.printf("{%d, %d, %d}\n", t[0], t[1], t[2]));
	}

}

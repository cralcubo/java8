package com.chris.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferencesTest {
	
	public static void main (String...strings){
		List<String> title = Arrays.asList("Christian", "Roman", "Rua");
		
		Stream<String> titleStream = title.stream();
		titleStream.forEach(s -> System.out.println(s));
		
		Stream<String> newTitleStream = title.stream();
		newTitleStream.forEach(System.out::println);
	}

}

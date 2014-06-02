package com.chris.stream;

import java.util.stream.Stream;

public class StreamOf {
	
	public static void main(String...strings ){
		//Stream of strings
		Stream<String> streamOfStrings = Stream.of("Java 8", "is", "cool");
		String flatString = streamOfStrings.map(String::toUpperCase).reduce("", (s1, s2) -> s1.concat(" ").concat(s2));
		System.out.println(flatString);
		
	}

}

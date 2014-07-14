package com.chris.optional;

import java.util.Map;
import java.util.Optional;

public class OptionalRefactoring {
	
	public static Optional<Integer> parseInteger(String number){
		try{
			return Optional.of(Integer.parseInt(number));
		}catch(NumberFormatException e){
			return Optional.empty();
		}
	}
	
	public static Optional<Object> mayNullable(Map<Object, String> map, String key){
		return Optional.ofNullable(map.get(key));
	}

}

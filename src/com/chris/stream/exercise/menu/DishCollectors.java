package com.chris.stream.exercise.menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DishCollectors {
	
	
	
	public static void main(String ...strings){
		
		List<Dish> menu = TestDish.menu;
		
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		
		
		
				
		
		
		
	}

}

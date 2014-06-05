package com.chris.stream.exercise.menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.chris.stream.exercise.menu.Dish.Type;

public class DishCollectors {
	enum CaloricLevel {DIET, NORMAL, FAT};
	
	public static void main(String ...strings){
		
		List<Dish> menu = TestDish.menu;
		
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		printer(dishesByType);
		
		Map<CaloricLevel, List<Dish>> dishesByCalories = menu.stream().collect(Collectors.groupingBy(DishCollectors::getCaloricLevel));
		printer(dishesByCalories);
		
		//Two level grouping
		System.out.println("----------------------------------");
		Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCalories = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(DishCollectors::getCaloricLevel)));
		for(Type type : dishesByTypeAndCalories.keySet()){
			System.out.print(type + ":\n[ ");
			printer(dishesByTypeAndCalories.get(type));
			System.out.println("]");
			
		}
		
		
	}
	
	private static void printer(Map<?, ? extends List<Dish>> map){
		map.keySet().stream().forEach(t -> {
			System.out.print(t + " {");
			map.get(t).stream().map(Dish::getName).forEach(n -> System.out.print(n +", "));
			System.out.println("}");
		});
	}
	
	private static CaloricLevel getCaloricLevel(Dish dish){
		if(dish.getCalories() <= 400) return CaloricLevel.DIET;
		else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		else return CaloricLevel.FAT;
	}

}

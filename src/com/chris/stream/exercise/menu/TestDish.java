package com.chris.stream.exercise.menu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class TestDish {
	
	public static List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), 
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), 
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void main(String... args){
		//Three high caloric dishes
		List<String> highCalDishes = menu.stream()
				.filter(dish -> dish.getCalories() > 500).sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName).distinct()
				.limit(3)
				.collect(Collectors.toList());
		System.out.printf("High calorics: %s \n", highCalDishes);
		//First two MEAT dishes
		List<String> twoMeats = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT)
				.limit(2)
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println("MEATS: " + twoMeats);
		
		//Optional use
		Optional<Dish> vegiDish =  menu.stream().filter(Dish::isVegetarian).findFirst();
		vegiDish.ifPresent(d -> System.out.println(d.getName()));
				
	}
}

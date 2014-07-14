package com.chris.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Product tv = new Product("TV");
		Product radio = new Product("Radio");
		Product computer = new Product("Computer");
		Product bike = new Product("Bike");
		
		List<Product> products = Arrays.asList(tv, radio, computer, bike);
		
		printWhileAvailable(products);
		

	}

	private static void printWhileAvailable(List<Product> products) throws InterruptedException, ExecutionException {
		List<Future<Product>> prices = products.stream().map(p -> p.getPriceAsync()).collect(Collectors.toList());
		
		while(true){
			for(Future<Product> p : new ArrayList<>(prices)){
				if(p.isDone()){
					System.out.printf("Product: %s - Price: %s \n", p.get().getName(), p.get().getPrice());
					prices.remove(p);
				}
			}
			if(prices.size() <= 0){
				break;
			}
		}
		
	}
	

}

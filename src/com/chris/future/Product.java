package com.chris.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Product {
	
	private String name;
	private Double price;
	
	public Product(String name) {
		this.name = name;
	}
	
	public Future<Product> getPriceAsync(){
		CompletableFuture<Product> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			setPrice(calculatePrice());
			futurePrice.complete(this);
		}).start();
		
		return futurePrice;
	}

	private double calculatePrice() {
		try {
			Random r = new Random();
			Thread.sleep(1000 * r.nextInt(3));
			return r.nextDouble() * name.charAt(0) * name.charAt(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

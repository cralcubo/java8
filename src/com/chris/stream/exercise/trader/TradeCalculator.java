package com.chris.stream.exercise.trader;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradeCalculator {
	
	private final List<Transaction> transactions;
	
	public TradeCalculator(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Transaction> sortAllTransactionPerYear(int year){
		return transactions.stream()
				.filter(t -> t.getYear() == year)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
	}
	
	public List<String> uniqueCitiesFilter(){
		return transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
	}
	
	public List<String> traderCityFilter(String city){
		return transactions.stream()
				.filter(t -> t.getTrader().getCity().equals(city))
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public List<String> getTradersNames(){
		return transactions.stream()
				.map(t -> t.getTrader()
				.getName())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public boolean findTraderByCity(String  city){
		return transactions.stream().anyMatch(t -> t.getTrader().getCity().equals(city));
	}
	
	public List<Integer> getTransactionsValuesPerCity(String city){
		return transactions.stream()
				.filter(t -> t.getTrader().getCity().equals(city))
				.map(Transaction::getValue)
				.collect(Collectors.toList());
	}
	
	public Transaction getHighestTransaction(){
		return transactions.stream().max((t1, t2) -> t1.getValue() - t2.getValue()).get();
	}
	
	public Transaction getLowestTransaction(){
		return transactions.stream().min((t1 , t2) -> t1.getValue() - t2.getValue()).get();
	}


}

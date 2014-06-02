package com.chris.stream.exercise.trader;

public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public int getYear() {
		return year;
	}

	public Trader getTrader() {
		return trader;
	}

	public String toString() {
		return String.format("{ %s , year: %s , value: %s}", 
				trader.toString(), year, value);
	}

}

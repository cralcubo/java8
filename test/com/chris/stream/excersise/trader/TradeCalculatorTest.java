package com.chris.stream.excersise.trader;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chris.stream.exercise.trader.TradeCalculator;
import com.chris.stream.exercise.trader.Trader;
import com.chris.stream.exercise.trader.Transaction;

public class TradeCalculatorTest {
	
	private TradeCalculator calculator;

	@Before
	public void setUp() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian,2011, 300),  new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012,710),
				new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		calculator = new TradeCalculator(transactions);
	}
	
	@Test
	public void testSortTransactions(){
		int year = 2012;
		calculator.sortAllTransactionPerYear(year).forEach(System.out::println);
	}
	
	@Test
	public void testUniqueCities(){
		calculator.uniqueCitiesFilter().forEach(System.out::println);
	}
	
	@Test
	public void testFilterByCity(){
		String city = "Cambridge";
		calculator.traderCityFilter(city).forEach(System.out::println);
	}
	
	@Test
	public void getAllTradersTest(){
		calculator.getTradersNames().forEach(System.out::println);
	}
	
	@Test
	public void findTraderByCity(){
		String city = "Milan";
		assertTrue(calculator.findTraderByCity(city ));
	}
	
	@Test
	public void testAllValueTradesPerCity(){
		String city = "Cambridge";
		calculator.getTransactionsValuesPerCity(city).forEach(System.out::println);
	}
	
	@Test
	public void testFindMaxAndMin(){
		System.out.println("Highest transaction: " + calculator.getHighestTransaction());
		System.out.println("Lowest transaction: " + calculator.getLowestTransaction());
		
	}
}

package com.chris.refactoring;

public class LambdasAmbiguity {
	
	public static void doSomething(Runnable r){
		r.run();
		System.out.println("I am a Runnable");
	}
	
	public static void doSomething(DangerousAction danger){
		danger.execute();
		System.out.println("I am DANGER!");
	}
	
	public static void main(String ...strings){
		LambdasAmbiguity.doSomething((Runnable)() -> System.out.println("What am I?"));
	}

}

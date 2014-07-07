package com.chris.optional;

import java.util.Optional;

import com.chris.optional.model.Car;
import com.chris.optional.model.Insurance;
import com.chris.optional.model.Person;

public class OptionalUse {

	public static void main(String... strings) {
		Person christian = new Person();
		Car honda = new Car();
		Insurance nn = new Insurance("National Nederlander");

		christian.setCar(Optional.of(honda));
		honda.setInsurance(Optional.of(nn));

		printInsuranceName(Optional.of(christian));
		
		//Empty person
		printInsuranceName(Optional.empty());
		
		//Empty car
		Person pepe = new Person();
		pepe.setCar(Optional.ofNullable(null));
		printInsuranceName(Optional.of(pepe));
		
	}

	private static void printInsuranceName(Optional<Person> christian) {
		String insuranceName = christian.flatMap(Person::getCar)
				.flatMap(Car::getInsurance).map(Insurance::getName)
				.orElse("Uknown");
		
		System.out.println(insuranceName);
	}

}

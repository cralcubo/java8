package com.chris.optional;

import java.util.Optional;
import java.util.Properties;

import com.chris.optional.model.Car;
import com.chris.optional.model.Insurance;
import com.chris.optional.model.Person;

public class OptionalFilter {

	public String getCarInsuranceName(Optional<Person> person, int minAge) {

		return person.filter(p -> p.getAge() > minAge).flatMap(Person::getCar)
				.flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");

	}
	
	public int readDuration(Properties properties, String name){
		return Optional.ofNullable(properties.getProperty(name)).flatMap(OptionalRefactoring::parseInteger).filter(n -> n > 0).orElse(0);
	}

}

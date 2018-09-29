package com.jeonguk.stream;

import lombok.Data;

@Data
public class Person {
	private final String name;
	private final String country;
	private final String city;
	private final Pet pet;
}

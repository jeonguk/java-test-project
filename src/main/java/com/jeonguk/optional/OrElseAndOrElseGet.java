package com.jeonguk.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
public class OrElseAndOrElseGet {

	private static final List<String> names = Arrays.asList("John", "Jones", "Kelly", "Cristina", "Raven");

	public String getRandomName() {
		log.info("getRandomName() method - start");
		Random random = new Random();
		int index = random.nextInt(5);
		log.info("getRandomName() method - end");
		return names.get(index);
	}

	public String getNameUsingOrElse(String name) {
		return Optional.ofNullable(name)
				.orElse(getRandomName());
	}

	public String getNameUsingOrElseGet(String name) {
		return Optional.ofNullable(name)
				.orElseGet(() -> getRandomName());
	}

}

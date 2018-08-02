package com.jeonguk.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class OptionalTestJava8Test {

	private Address address = new Address("52/A, 22nd Street",
		"Mumbai", "India", 400001);

	private Address nullAddress = null;

	@Test
	public void optionalOfNullElse_Test() {
		String cityName = Optional.of(address).map(Address::city).orElse("");
		assertEquals("Mumbai", cityName);
	}

	@Test
	public void optionalOfNullElse_Test2() {
		String cityName = Optional.ofNullable(nullAddress).map(Address::city).orElse("");
		assertEquals("", cityName);
	}
}

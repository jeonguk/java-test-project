package com.jeonguk.junit;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@FixMethodOrder()
public class DefaultOrderOfExecutionTest {
	private static StringBuilder output = new StringBuilder("");

	@Test
	public void secondTest() {
		output.append("b");
	}

	@Test
	public void thirdTest() {
		output.append("c");
	}

	@Test
	public void firstTest() {
		output.append("a");
	}

	@AfterClass
	public static void assertOutput() {
		assertEquals(output.toString(), "cab");
	}
}

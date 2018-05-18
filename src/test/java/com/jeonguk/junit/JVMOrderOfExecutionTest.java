package com.jeonguk.junit;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * Another ordering strategy is MethodSorters.JVM
 * – this strategy utilizes the natural JVM ordering
 * – which can be different for each run:
 */
@FixMethodOrder(MethodSorters.JVM)
public class JVMOrderOfExecutionTest {
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
		assertEquals(output.toString(), "acb");
	}
}

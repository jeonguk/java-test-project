package com.jeonguk.convert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringAmtConvertTest {

	@Test
	public void convert25MillionTest() {
		String givenAmt = "250000000";
		String resultAmt = StringAmtConvert.convertStrAmtToAmtStr(givenAmt);
		assertEquals("2억5000만원", resultAmt);
	}

	@Test
	public void convert5MillionTest() {
		String givenAmt = "50000000";
		String resultAmt = StringAmtConvert.convertStrAmtToAmtStr(givenAmt);
		assertEquals("5000만원", resultAmt);
	}
}

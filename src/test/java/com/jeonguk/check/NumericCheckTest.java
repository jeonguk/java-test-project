package com.jeonguk.check;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumericCheckTest {

	@Test
	public void numericCheckPlainJava_test() {
		assertTrue(NumericCheck.isNumericPlain("22"));
		assertTrue(NumericCheck.isNumericPlain("5.05"));
		assertTrue(NumericCheck.isNumericPlain("-200"));
		assertTrue(NumericCheck.isNumericPlain("10.0d"));
		assertTrue(NumericCheck.isNumericPlain("   22   "));

		assertFalse(NumericCheck.isNumericPlain(null));
		assertFalse(NumericCheck.isNumericPlain(""));
		assertFalse(NumericCheck.isNumericPlain("abc"));
	}

	@Test
	public void numericCheckRegx_test() {
		assertTrue(NumericCheck.isNumericRegx("22"));
		assertTrue(NumericCheck.isNumericRegx("5.05"));
		assertTrue(NumericCheck.isNumericRegx("-200"));

		assertFalse(NumericCheck.isNumericRegx("abc"));
	}

	// Apache Commons

	// NumberUtils.isCreatable(String)
	@Test
	public void numericCheckApacheCommons_isCreatableTest() {
		assertTrue(NumberUtils.isCreatable("22"));
		assertTrue(NumberUtils.isCreatable("5.05"));
		assertTrue(NumberUtils.isCreatable("-200"));
		assertTrue(NumberUtils.isCreatable("10.0d"));
		assertTrue(NumberUtils.isCreatable("1000L"));
		assertTrue(NumberUtils.isCreatable("0xFF"));
		assertTrue(NumberUtils.isCreatable("07"));
		assertTrue(NumberUtils.isCreatable("2.99e+8"));

		assertFalse(NumberUtils.isCreatable(null));
		assertFalse(NumberUtils.isCreatable(""));
		assertFalse(NumberUtils.isCreatable("abc"));
		assertFalse(NumberUtils.isCreatable(" 22 "));
		assertFalse(NumberUtils.isCreatable("09"));
	}

	// NumberUtils.isParsable(String)
	@Test
	public void numericCheckApacheCommons_isParsableTest() {
		assertTrue(NumberUtils.isParsable("22"));
		assertTrue(NumberUtils.isParsable("-23"));
		assertTrue(NumberUtils.isParsable("2.2"));
		assertTrue(NumberUtils.isParsable("09"));

		assertFalse(NumberUtils.isParsable(null));
		assertFalse(NumberUtils.isParsable(""));
		assertFalse(NumberUtils.isParsable("6.2f"));
		assertFalse(NumberUtils.isParsable("9.8d"));
		assertFalse(NumberUtils.isParsable("22L"));
		assertFalse(NumberUtils.isParsable("0xFF"));
		assertFalse(NumberUtils.isParsable("2.99e+8"));
	}

	// StringUtils.isNumeric(CharSequence)
	@Test
	public void numericCheckApacheCommons_isNumericTest() {
		assertTrue(StringUtils.isNumeric("123"));
		assertTrue(StringUtils.isNumeric("١٢٣"));
		assertTrue(StringUtils.isNumeric("१२३"));

		assertFalse(StringUtils.isNumeric(null));
		assertFalse(StringUtils.isNumeric(""));
		assertFalse(StringUtils.isNumeric("  "));
		assertFalse(StringUtils.isNumeric("12 3"));
		assertFalse(StringUtils.isNumeric("ab2c"));
		assertFalse(StringUtils.isNumeric("12.3"));
		assertFalse(StringUtils.isNumeric("-123"));
	}

	// StringUtils.isNumericSpace(CharSequence)

	@Test
	public void numericCheckApacheCommons_isNumericSpaceTest() {
		assertTrue(StringUtils.isNumericSpace("123"));
		assertTrue(StringUtils.isNumericSpace("١٢٣"));
		assertTrue(StringUtils.isNumericSpace(""));
		assertTrue(StringUtils.isNumericSpace("  "));
		assertTrue(StringUtils.isNumericSpace("12 3"));

		assertFalse(StringUtils.isNumericSpace(null));
		assertFalse(StringUtils.isNumericSpace("ab2c"));
		assertFalse(StringUtils.isNumericSpace("12.3"));
		assertFalse(StringUtils.isNumericSpace("-123"));
	}
}

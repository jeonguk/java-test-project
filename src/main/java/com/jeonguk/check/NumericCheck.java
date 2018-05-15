package com.jeonguk.check;

public class NumericCheck {

	private NumericCheck() {}

	// Plain Java
	public static boolean isNumericPlain(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	// Regular Expressions
	public static boolean isNumericRegx(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");
	}
}

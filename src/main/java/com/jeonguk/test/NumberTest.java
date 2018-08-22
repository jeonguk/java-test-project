package com.jeonguk.test;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class NumberTest {

	public static void main(String[] ar) {
		String strNumber = "200500000";
		final double db = Double.parseDouble(strNumber);
		final DecimalFormat d = new DecimalFormat("#,####");

		final String[] unit = new String[]{"", "만","억","조"};
		final String[] str = d.format(db).split(",");
		final StringBuilder result = new StringBuilder();
		int cnt = 0;
		for(int i = str.length; i > 0; i--) {
			if(Integer.parseInt(str[i-1]) != 0) {
				result.insert(0, String.valueOf(Integer.parseInt(str[i - 1])) + unit[cnt]);
			}
			cnt++;
		}
		log.info("result {}원", result);
	}

}

package com.jeonguk.test;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class StringBufferTest {

	public static void main(String[] args) {

		log.info("{}", convert("100000"));
	}

	public static String convert(String money) {
		final double db = Double.parseDouble(money);
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
		result.append("원");
		return result.toString();
	}
}

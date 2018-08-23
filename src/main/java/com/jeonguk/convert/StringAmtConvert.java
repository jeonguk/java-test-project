package com.jeonguk.convert;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

@Slf4j
public class StringAmtConvert {

	public static void main(String[] ar) {
		String strAmt = "250000000";
		log.info("convertStrAmtToAmtStr 250000000 = {}", convertStrAmtToAmtStr(strAmt));
	}

	public static String convertStrAmtToAmtStr(String strAmt) {
		final double db = Double.parseDouble(StringUtils.defaultIfBlank(strAmt, "0"));
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

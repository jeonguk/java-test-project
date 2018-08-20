package com.jeonguk.string;

import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

@Slf4j
public class StringJoinerTest {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
		sj.add("2016");
		sj.add("02");
		sj.add("26");
		String result = sj.toString(); //prefix-2016/02/26-suffix

		String dt = "20180814110211";
		String fromCstNo = "10000000001";
		String toCstNo = "20000000002";

		String joinStr = String.join("_", dt, fromCstNo, toCstNo);

		log.info("joinStr {}", joinStr);
	}
}

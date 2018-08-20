package com.jeonguk.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

@Slf4j
public class RandomStringUtilsTest {

	public static void main(String[] args) {
		log.info("random numeric {}", RandomStringUtils.randomNumeric(10));
	}
}

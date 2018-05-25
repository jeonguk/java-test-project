package com.jeonguk.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamMapFileterTest {

	public static void main(String[] args) {
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		log.info("original list: {}", numbers);

		List<Integer> even = numbers.stream()
				.map(s -> Integer.valueOf(s))
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());

		log.info("processed list, only even numbers: {}", even);
	}
}

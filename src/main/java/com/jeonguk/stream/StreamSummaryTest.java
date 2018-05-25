package com.jeonguk.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class StreamSummaryTest {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(
				new Person("John Blue", 28),
				new Person("Anna Brown", 53),
				new Person("Paul Black", 47)
		);

		int min = list.stream()
				.mapToInt(Person::getAge)
				.min()
				.orElseThrow(NoSuchElementException::new);

		int max = list.stream()
				.mapToInt(Person::getAge)
				.max()
				.orElseThrow(NoSuchElementException::new);

		IntSummaryStatistics statistics = list.stream()
				.mapToInt(Person::getAge)
				.summaryStatistics();

//        int min = statistics.getMin();
//        int max = statistics.getMax();
		log.info("min {}  max {}", min, max);
	}

	@AllArgsConstructor
	@Data
	private static class Person {
		private String name;
		private int age;
	}
}

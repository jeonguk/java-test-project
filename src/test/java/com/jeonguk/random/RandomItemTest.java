package com.jeonguk.random;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Picking a Random Item/Items
 */
public class RandomItemTest {
	// Single Random Item
	@Test
	public void givenList_shouldReturnARandomElement() {
		List<Integer> givenList = Arrays.asList(1, 2, 3);
		Random rand = new Random();
		int randomElement = givenList.get(rand.nextInt(givenList.size()));
		System.out.println(randomElement);
	}

	// Select Random Items With Repetitions
	@Test
	public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
		Random rand = new Random();
		List<String> givenList = Arrays.asList("one", "two", "three", "four");

		int numberOfElements = 2;

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			String randomElement = givenList.get(randomIndex);
			System.out.println("Repetitions = "+randomElement);
		}
	}

	// Select Random Items Without Repetitions
	@Test
	public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat() {
		Random rand = new Random();
		List<String> givenList = Lists.newArrayList("a", "b", "c", "d");

		int numberOfElements = 2;

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			String randomElement = givenList.get(randomIndex);
			System.out.println("Repetitions = "+randomElement);
			givenList.remove(randomIndex);
		}
	}

	// Select Random Series
	@Test
	public void givenList_whenSeriesLengthChosen_shouldReturnRandomSeries() {
		List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
		Collections.shuffle(givenList);

		int randomSeriesLength = 3;

		List<Integer> randomSeries = givenList.subList(0, randomSeriesLength);
		randomSeries.forEach(r -> System.out.println(r.toString()));
	}

	@Test
	public void name() {
		List<String> givenList = Lists.newArrayList("a", "b", "c", "d", "e", "f");
		Collections.shuffle(givenList);
		int randomSeriesLength = 1;

		String randomStr = givenList.get(0);
		System.out.println(randomStr);

//		List<String> randomSeries = givenList.subList(0, randomSeriesLength);
//		randomSeries.stream().forEach(r -> System.out.println(r));
	}
}

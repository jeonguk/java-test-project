package com.jeonguk.list;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class RemoveAllDuplicateListTest {

	// Remove duplicates from a List using plain Java
	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithPlainJava_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(0, 1, 2, 3, 0, 0);
		List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

		assertThat(listWithoutDuplicates, hasSize(4));
	}

	// Remove duplicates from a List using Guava
	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithGuava_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(0, 1, 2, 3, 0, 0);
		List<Integer> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(listWithDuplicates));

		assertThat(listWithoutDuplicates, hasSize(4));
	}

	// Remove duplicates from a List using Java 8 Lambdas
	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(1, 1, 2, 2, 3, 3);
		List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
				.distinct()
				.collect(Collectors.toList());
		assertThat(listWithoutDuplicates, hasSize(3));
	}
}

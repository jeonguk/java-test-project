package com.jeonguk.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class IterativeBinarySearch {

	public static void main(String[] args) {
		int[] list = new int[]{23, 15, 20, 41, 12, 3, 24, 26, 43, 18, 40, 33, 7, 35, 37};
		int number = 12;
		Arrays.sort(list);
		log.info("Binary Search {} in integer array {}", number, Arrays.toString(list));

		binarySearch(list, 12);

		log.info("Binary Search {} in integer array {}", 43, Arrays.toString(list));

		binarySearch(list, 43);

		list = new int[]{123, 243, 331, 1298};
		number = 331;
		Arrays.sort(list);
		log.info("Binary Search {} in integer array {}", number, Arrays.toString(list));

		binarySearch(list, 331);

		log.info("Binary Search {} in integer array {}", 331, Arrays.toString(list));

		binarySearch(list, 1333);

		// Using Core Java API and Collection framework
		// Precondition to the Arrays.binarySearch
		Arrays.sort(list);

		// Search an element
		int index = Arrays.binarySearch(list, 3);
	}

	public static void binarySearch(int[] input, int number) {
		int first = 0;
		int last = input.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (input[middle] < number) {
				first = middle + 1;
			} else if (input[middle] == number) {
				log.info("{} found at location {}", number, middle);
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		if (first > last) {
			log.info("{} is not present in the list.\n");
		}
	}
}

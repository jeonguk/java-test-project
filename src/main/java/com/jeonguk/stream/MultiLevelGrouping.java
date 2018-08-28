package com.jeonguk.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class MultiLevelGrouping {

	public static void main(String[] args) {
		Person person1 = new Person("AAA", "KOR", "SEOUL", new Pet("CAT", 7));
		Person person2 = new Person("BBB", "JP", "TOKYO", new Pet("DOG", 5));
		Person person3 = new Person("CCC", "KOR", "SUWON", new Pet("CAT", 3));
		Person person4 = new Person("DDD", "KOR", "INCHON", new Pet("DOG", 1));
		Person person5 = new Person("EEE", "JP", "OSAKA", new Pet("DOG", 3));

		List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

		singleLevelGrouping(personList);

		twoLevelGrouping(personList);

		threeLevelGrouping(personList);
	}

	// Single Level Grouping
	public static void singleLevelGrouping(List<Person> personList) {
		final Map<String, List<Person>> personsByCountry = personList.stream().collect(groupingBy(Person::getCountry));
		log.info("PersonList in KOR: {}", personsByCountry.get("KOR"));
	}

	public static void twoLevelGrouping(List<Person> personList) {
		final Map<String, Map<String, List<Person>>> personByCountryAdnCity = personList.stream().collect(
			groupingBy(Person::getCountry, groupingBy(Person::getCity))
		);
		log.info("Person Living in JP : {}", personByCountryAdnCity.get("JP").get("TOKYO").size());
	}

	public static void threeLevelGrouping(List<Person> personList) {
		final Map<String, Map<String, Map<String, List<Person>>>> personsByCountryCityAndPetName = personList.stream().collect(groupingBy(Person::getCountry, groupByCityAndPetName()));
		log.info("Persons whose pet is named 'CAT' and live in SEOUL {}", personsByCountryCityAndPetName.get("KOR").get("SEOUL").get("CAT").size());
	}

	private static Collector<Person, ?, Map<String, Map<String, List<Person>>>> groupByCityAndPetName() {
		return groupingBy(Person::getCity, groupingBy(p -> p.getPet().getName()));
	}
}

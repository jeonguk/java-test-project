package com.jeonguk.hamcrest;

import com.google.common.collect.Lists;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HamcrestTest {

	/**
	 *  Common Core Matchers
	 */

	// is(T)and is(Matcher<T>)
	@Test
	public void hamcrestIsMatch_test() {
		String testString = "hamcrest core";

		assertThat(testString, is("hamcrest core"));
		assertThat(testString, is(equalTo("hamcrest core")));
	}

	// equalTo(T)
	@Test
	public void hamcrestEquatTo_test() {
		String actualString = "equalTo match";
		List<String> actualList = Lists.newArrayList("equalTo", "match");

		assertThat(actualString, is(equalTo("equalTo match")));
		assertThat(actualList, is(equalTo(Lists.newArrayList("equalTo", "match"))));
	}

	// not(T)and not(Matcher<T>)
	@Test
	public void hamcrestNotMatch_test() {
		String testString = "troy kingdom";

		assertThat(testString, not("german kingdom"));
		assertThat(testString, is(not(equalTo("german kingdom"))));
		assertThat(testString, is(not(instanceOf(Integer.class))));
	}

	// nullValue()and nullValue(Class<T>)
	@Test
	public void hamcrestNullValue_test() {
		Integer nullObject = null;

		assertThat(nullObject, is(nullValue()));
		assertThat(nullObject, is(nullValue(Integer.class)));
	}

	// notNullValue()and notNullValue(Class<T>)
	@Test
	public void hamcrestNotNullValue_test() {
		Integer testNumber = 123;

		assertThat(testNumber, is(notNullValue()));
		assertThat(testNumber, is(notNullValue(Integer.class)));
	}

	// instanceOf(Class<?>)
	@Test
	public void hamcrestInstanceOf_test() {
		assertThat("instanceOf example", is(instanceOf(String.class)));
	}

	// isA(Class<T> type)
	@Test
	public void hamcrestIsA_test() {
		assertThat("Drogon is biggest dragon", isA(String.class));
	}

	// sameInstance()
	@Test
	public void hamcrestSameInstance_test() {
		String string1 = "Viseron";
		String string2 = string1;

		assertThat(string1, is(sameInstance(string2)));
	}

	// any(Class<T>)
	@Test
	public void hamcrestAny_test() {
		assertThat("test string", is(any(String.class)));
		assertThat("test string", is(any(Object.class)));
	}

	// allOf(Matcher<? extends T>…) and anyOf(Matcher<? extends T>…)
	@Test
	public void hamcrestAllOfAnyOf_test() {
		String testString1 = "Achilles is powerful";
		assertThat(testString1, allOf(startsWith("Achi"), endsWith("ul"), containsString("Achilles")));

		String testString2 = "Hector killed Achilles";
		assertThat(testString2, anyOf(startsWith("Hec"), containsString("baeldung")));
	}

	// hasItem(T)and hasItem(Matcher<? extends T>)
	@Test
	public void hamcrestHasItem_test() {
		List<String> list1 = Lists.newArrayList("java", "spring", "baeldung");

		assertThat(list1, hasItem("java"));
		assertThat(list1, hasItem(isA(String.class)));

		List<String> list2 = Lists.newArrayList("java", "spring", "baeldung");

		assertThat(list2, hasItems("java", "baeldung"));
		assertThat(list2, hasItems(isA(String.class), endsWith("ing")));
	}

	// both(Matcher<? extends T>) and either(Matcher<? extends T>)
	@Test
	public void hamcrestBothEither_test() {
		String testString1 = "daenerys targaryen";
		assertThat(testString1, both(startsWith("daene")).and(containsString("yen")));

		String testString2 = "daenerys targaryen";
		assertThat(testString2, either(startsWith("tar")).or(containsString("targaryen")));
	}

}

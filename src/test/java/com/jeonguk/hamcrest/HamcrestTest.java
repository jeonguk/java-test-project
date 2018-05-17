package com.jeonguk.hamcrest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
}

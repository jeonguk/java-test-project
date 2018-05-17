package com.jeonguk.hamcrest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
}

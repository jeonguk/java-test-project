package com.jeonguk.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Slf4j
public class OptionalOrElseThrowTest {

	public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

	public String pickLuckyNameOldWay(final List<String> names, final String startingLetter) {
		String luckyName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				luckyName = name;
				break;
			}
		}
		if (luckyName == null) {
			throw new NotFoundException("There is no name starting with letter.");
		}
		return luckyName;
	}

	public String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
		final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		return luckyName.orElseThrow(() -> new NotFoundException("There is no name starting with letter."));
	}

	public String checkNullPointerException() {
		String str = null;
		return Optional.ofNullable(str).orElseThrow(() -> new NullPointerException());
	}

	@Test(expected = NullPointerException.class)
	public void testThrows() {
		checkNullPointerException();
	}

	@Test
	public void testPickLuckyNameOldWay() {
		assertEquals("Nita", pickLuckyNameOldWay(NAMES, "N"));
		assertEquals("Yogen", pickLuckyNameOldWay(NAMES, "Y"));
		//assertEquals("There is no name starting with letter.", pickLuckyNameOldWay(NAMES, "Q"));
	}

	@Test
	public void testPickLuckyNameWOrElseOk() {
		assertEquals("Nita", pickLuckyNameWOrElse(NAMES, "N"));
		assertEquals("Yogen", pickLuckyNameWOrElse(NAMES, "Y"));
	}

	@Test(expected = NotFoundException.class)
	public void testPickLuckyNameWOrElseException() {
		pickLuckyNameWOrElse(NAMES, "Q");
		pickLuckyNameWOrElse(NAMES, "1");
	}
}

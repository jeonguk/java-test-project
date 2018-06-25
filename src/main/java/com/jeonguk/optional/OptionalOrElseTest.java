package com.jeonguk.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Slf4j
public class OptionalOrElseTest {

	public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

	public String pickLuckyNameOldWay(final List<String> names, final String startingLetter) {
		String luckyName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				luckyName = name;
				break;
			}
		}
		return luckyName != null ? luckyName : "No lucky name found";
	}

	public String pickLuckyNameWIsPresent(final List<String> names, final String startingLetter) {
		final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		return luckyName.isPresent() ? luckyName.get() : "No lucky name found";
	}

	public String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
		final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		return luckyName.orElse("No lucky name found");
	}

	public static void main(String[] args) {
		OptionalOrElseTest ooet = new OptionalOrElseTest();
		log.info("pickLuckyNameWOrElse {}", ooet.pickLuckyNameWOrElse(NAMES,"N"));
	}

//	@Test
//	public void testPickLuckyNameOldWay() {
//		assertEquals("Nita", pickLuckyNameOldWay(NAMES, "N"));
//		assertEquals("Yogen", pickLuckyNameOldWay(NAMES, "Y"));
//		assertEquals("No lucky name found", pickLuckyNameOldWay(NAMES, "Q"));
//	}
//
//	@Test
//	public void testPickLuckyNameWIsPresent() {
//		assertEquals("Nita", pickLuckyNameWIsPresent(NAMES, "N"));
//		assertEquals("Yogen", pickLuckyNameWIsPresent(NAMES, "Y"));
//		assertEquals("No lucky name found", pickLuckyNameWIsPresent(NAMES, "Q"));
//	}
//
//	@Test
//	public void testPickLuckyNameWOrElse() {
//		assertEquals("Nita", pickLuckyNameWOrElse(NAMES, "N"));
//		assertEquals("Yogen", pickLuckyNameWOrElse(NAMES, "Y"));
//		assertEquals("No lucky name found", pickLuckyNameWOrElse(NAMES, "Q"));
//	}
}

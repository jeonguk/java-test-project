package com.jeonguk.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class OptionalIfPresentTest {

	public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

	public static void main(String[] args) {
		pickLuckyNameNewWay(NAMES, "Y");
	}

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

	public static void pickLuckyNameNewWay(final List<String> names, final String startingLetter) {
		final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		luckyName.ifPresent(OptionalIfPresentTest::postMessage);
	}

	public static void postMessage(final String winnerName) {
		log.info("Congratulations {}", winnerName);
	}

}

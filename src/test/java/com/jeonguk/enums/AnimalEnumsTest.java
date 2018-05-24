package com.jeonguk.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.jeonguk.enums.Animal.DOG;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Slf4j
public class AnimalEnumsTest {
	@Test
	public void givenEnumConstant_whenCallNameAndToString_shouldReturnSameValue() {
		log.info("DOG.toString() {}", DOG.toString());
		log.info("DOG.name() {}", DOG.name());
		assertThat(DOG.toString()).isEqualTo(DOG.name());
	}
}

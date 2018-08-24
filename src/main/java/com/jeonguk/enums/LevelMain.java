package com.jeonguk.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LevelMain {
	public static void main(String[] args) {
		for (Level level : Level.values()) {
			log.info("level value = {}", level);
		}

		String levelText = Level.HIGH.toString();
		log.info("levelText = {}", levelText);

		log.info("Level.HIHG = {}", Level.HIGH);

		log.info("Level.valueOf = {}", Level.valueOf("HIGH"));

		Level level = Level.HIGH;
		log.info("levelCode = {}", level.getLevelCode());

	}
}

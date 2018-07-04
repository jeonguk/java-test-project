package com.jeonguk.localdatetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
public class LocalDateTimeMain {

	public static void main(String[] args) {
		final Date nowDate = new Date();
		log.info("convertToLocalDateViaInstant {}", convertToLocalDateViaInstant(nowDate));
		log.info("convertToLocalDateViaMilisecond {}", convertToLocalDateViaMilisecond(nowDate));
		log.info("convertToLocalDateViaSqlDate {}", convertToLocalDateViaSqlDate(nowDate));

		log.info("convertToLocalDateTimeViaInstant {}", convertToLocalDateTimeViaInstant(nowDate));
		log.info("convertToLocalDateTimeViaMilisecond {}", convertToLocalDateTimeViaMilisecond(nowDate));

		final LocalDate nowLocalDate = LocalDate.now();
		log.info("convertToDateViaSqlDate {}", convertToDateViaSqlDate(nowLocalDate));
		log.info("convertToDateViaInstant {}", convertToDateViaInstant(nowLocalDate));

		final LocalDateTime nowLocalDateTime = LocalDateTime.now();
		log.info("convertToDateViaSqlTimestamp {}", convertToDateViaSqlTimestamp(nowLocalDateTime));
		log.info("convertToDateViaInstant {}", convertToDateViaInstant(nowLocalDate));
	}

	// Converting java.util.Date to java.time.LocalDate

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	// Converting java.util.Date to java.time.LocalDateTime

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
	}

	public static LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
	}

	// Convert java.time.LocalDate to java.util.Date
	public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay()
				.atZone(ZoneId.systemDefault())
				.toInstant());
	}

	// Convert java.time.LocalDateTime to java.util.Date

	public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
		return java.sql.Timestamp.valueOf(dateToConvert);
	}

	public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date
				.from(dateToConvert.atZone(ZoneId.systemDefault())
						.toInstant());
	}
}

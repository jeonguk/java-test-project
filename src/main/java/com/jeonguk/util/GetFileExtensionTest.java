package com.jeonguk.util;

import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.util.Optional;

@Slf4j
public class GetFileExtensionTest {

	public static void main(String[] args) {
		final String testFile = "test/testfilename.txt";
		log.info("file name {}", getExtensionByStringHandling(testFile));
		log.info("file name {}", getExtensionByApacheCommonsLib(testFile));
		log.info("file name {}", getExtensionByGuava(testFile));
	}

	public static Optional<String> getExtensionByStringHandling(String fileName) {
		return Optional.ofNullable(fileName)
				.filter(f -> f.contains("."))
				.map(f -> f.substring(fileName.lastIndexOf(".") + 1));
	}

	// FilenameUtils.getExtension from Apache Commons IO
	public static String getExtensionByApacheCommonsLib(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}

	// Using the Guava Library
	public static String getExtensionByGuava(String fileName) {
		return Files.getFileExtension(fileName);
	}
}

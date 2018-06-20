package com.jeonguk.base64;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.UUID;

@Slf4j
public class Base64Test {
	public static void main(String[] args) {
		// Java 8 Basic Base64
		String originalInput = "test input";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		log.info("encodedString {}", originalInput);

		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		log.info("decodedString {}", decodedString);

		// Java 8 Base64 Encoding without Padding
		String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
		log.info("encodedUrl {}", encodedUrl);

		decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
		String decodedUrl = new String(decodedBytes);
		log.info("originalUrl {}", originalUrl);
		log.info("decodedUrl  {}", decodedUrl);

		// Java 8 MIME Encoding
		StringBuilder buffer = getMimeBuffer();
		byte[] encodedAsBytes = buffer.toString().getBytes();
		String encodedMime = Base64.getMimeEncoder().encodeToString(encodedAsBytes);
		log.info("encodedMime {}", encodedMime);

		decodedBytes = Base64.getMimeDecoder().decode(encodedMime);
		String decodedMime = new String(decodedBytes);
		log.info("decodedMime {}", decodedMime);

	}

	private static StringBuilder getMimeBuffer() {
		StringBuilder buffer = new StringBuilder();
		for (int count = 0; count < 10; count++) {
			buffer.append(UUID.randomUUID().toString());
		}
		return buffer;
	}


}

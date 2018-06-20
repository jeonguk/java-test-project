package com.jeonguk.base64;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

/**
 * Encoding/Decoding Using Apache Commons Code
 */
@Slf4j
public class ApacheCommonsBase64Test {
	public static void main(String[] args) {
		String originalInput = "test input";
		Base64 base64 = new Base64();
		String encodedString = new String(base64.encode(originalInput.getBytes()));
		log.info("encodedString {}", encodedString);

		String decodedString = new String(base64.decode(encodedString.getBytes()));
		log.info("decodedString {}", decodedString);

		// using the static API of Base64
		String encodedStaticString = new String(Base64.encodeBase64(originalInput.getBytes()));
		log.info("encodedStaticString {}", encodedStaticString);
		String decodedStaticString = new String(Base64.decodeBase64(encodedStaticString.getBytes()));
		log.info("decodedStaticString {}", decodedStaticString);
	}
}

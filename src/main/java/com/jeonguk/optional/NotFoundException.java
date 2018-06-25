package com.jeonguk.optional;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}
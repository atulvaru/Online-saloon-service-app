package com.app.exception;

import lombok.Getter;

@Getter
public class StaffException extends RuntimeException {

	public StaffException(String message, Throwable cause) {
		super(message, cause);

	}

	public StaffException(String message) {
		super(message);

	}
}

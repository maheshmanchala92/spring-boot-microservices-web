package com.training.add.exception;

public class DuplicateItemFoundException extends RuntimeException {

	private static final long serialVersionUID = 8187890300942769232L;

	public DuplicateItemFoundException(String message) {
		super(message);
	}
}

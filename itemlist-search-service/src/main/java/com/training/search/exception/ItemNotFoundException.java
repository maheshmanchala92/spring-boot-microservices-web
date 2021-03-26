package com.training.search.exception;

public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8187890300942769232L;

	public ItemNotFoundException(String message) {
		super(message);
	}
}

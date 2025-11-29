package com.arthur_pereira.supermercado.exceptions;

public class BadLoginException extends RuntimeException {

	public BadLoginException(String message) {
		super(message);
	}

	public BadLoginException() {
		super();
	}
	
	
	

}

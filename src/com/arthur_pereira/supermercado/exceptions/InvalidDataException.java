package com.arthur_pereira.supermercado.exceptions;

public class InvalidDataException extends RuntimeException {
	
	public InvalidDataException(String msg) {
		super(msg);
	}
	
	public InvalidDataException() {
		super();
	}

}

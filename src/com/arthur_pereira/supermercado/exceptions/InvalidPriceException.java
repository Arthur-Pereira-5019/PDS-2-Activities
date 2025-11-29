package com.arthur_pereira.supermercado.exceptions;

public class InvalidPriceException extends RuntimeException {
	
	public InvalidPriceException(String msg) {
		super(msg);
	}
	
	public InvalidPriceException() {
		super();
	}

}

package com.arthur_pereira.supermercado.exceptions;

public class InvalidBuyException extends RuntimeException {
	
	public InvalidBuyException(String msg) {
		super(msg);
	}
	
	public InvalidBuyException() {
		super();
	}

}

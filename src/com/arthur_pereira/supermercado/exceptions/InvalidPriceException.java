package com.arthur_pereira.supermercado.exceptions;

public class InvalidPriceException extends GenericProductException {
	
	public InvalidPriceException(String msg) {
		super(msg);
	}
	
	public InvalidPriceException() {
		super();
	}

}

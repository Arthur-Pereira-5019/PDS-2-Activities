package com.arthur_pereira.supermercado.exceptions;

public class InvalidNameException extends GenericProductException {
	
	public InvalidNameException(String msg) {
		super(msg);
	}
	
	public InvalidNameException() {
		super();
	}

}

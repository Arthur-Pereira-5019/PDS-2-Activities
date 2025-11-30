package com.arthur_pereira.supermercado.exceptions;

public class InvalidIDException extends GenericProductException {
	
	public InvalidIDException(String msg) {
		super(msg);
	}
	
	public InvalidIDException() {
		super();
	}

}

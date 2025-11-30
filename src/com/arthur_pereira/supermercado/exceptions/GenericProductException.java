package com.arthur_pereira.supermercado.exceptions;

public class GenericProductException extends RuntimeException{
	public GenericProductException(String msg) {
		super(msg);
	}
	
	public GenericProductException() {
		super();
	}
}

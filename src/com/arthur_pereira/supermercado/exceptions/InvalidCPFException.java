package com.arthur_pereira.supermercado.exceptions;

public class InvalidCPFException extends RuntimeException {
	
	public InvalidCPFException(String msg) {
		super(msg);
	}
	
	public InvalidCPFException() {
		super();
	}

}

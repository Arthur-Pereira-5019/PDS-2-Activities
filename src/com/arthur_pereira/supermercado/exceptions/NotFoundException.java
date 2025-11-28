package com.arthur_pereira.supermercado.exceptions;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException(String msg) {
		super(msg);
	}
	
	public NotFoundException() {
		super();
	}

}

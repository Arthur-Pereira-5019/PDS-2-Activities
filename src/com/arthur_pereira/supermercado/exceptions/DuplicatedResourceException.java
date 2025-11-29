package com.arthur_pereira.supermercado.exceptions;

public class DuplicatedResourceException extends RuntimeException {
	
	public DuplicatedResourceException(String msg) {
		super(msg);
	}
	
	public DuplicatedResourceException() {
		super();
	}

}

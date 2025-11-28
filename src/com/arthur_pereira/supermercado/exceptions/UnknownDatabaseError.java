package com.arthur_pereira.supermercado.exceptions;

public class UnknownDatabaseError extends RuntimeException {
	
	public UnknownDatabaseError(String msg) {
		super(msg);
	}
	
	public UnknownDatabaseError() {
		super();
	}

}

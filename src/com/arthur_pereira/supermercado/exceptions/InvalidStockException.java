package com.arthur_pereira.supermercado.exceptions;

public class InvalidStockException extends RuntimeException {
	
	public InvalidStockException(String msg) {
		super(msg);
	}
	
	public InvalidStockException() {
		super();
	}

}

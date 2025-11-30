package com.arthur_pereira.supermercado.exceptions;

public class InvalidStockException extends GenericProductException {
	
	public InvalidStockException(String msg) {
		super(msg);
	}
	
	public InvalidStockException() {
		super();
	}

}

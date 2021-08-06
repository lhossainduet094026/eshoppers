package com.lokman.shoppingcart.util;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}

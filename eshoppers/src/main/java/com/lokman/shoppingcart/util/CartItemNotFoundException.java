package com.lokman.shoppingcart.util;

public class CartItemNotFoundException extends RuntimeException {
	public CartItemNotFoundException(String message) {
		super(message);
	}
}

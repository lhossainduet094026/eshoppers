package com.lokman.shoppingcart.util;

public class StringUtil {
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	private static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}
}

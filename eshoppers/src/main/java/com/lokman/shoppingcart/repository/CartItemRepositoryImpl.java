package com.lokman.shoppingcart.repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.lokman.shoppingcart.domain.CartItem;

public class CartItemRepositoryImpl implements CartItemRepository {

	private static final Set<CartItem> CARTS = new CopyOnWriteArraySet<>();

	@Override
	public CartItem save(CartItem cartItem) {
		CARTS.add(cartItem);
		return cartItem;
	}

	@Override
	public CartItem update(CartItem cartItem) {
		CARTS.add(cartItem);
		return cartItem;
	}

	@Override
	public void remove(CartItem cartItem) {
		CARTS.remove(cartItem);
	}

}

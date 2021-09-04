package com.lokman.shoppingcart.repository;

import com.lokman.shoppingcart.domain.CartItem;

public interface CartItemRepository {
	CartItem save(CartItem cartItem);

	CartItem update(CartItem cartItem);

	void remove(CartItem cartItem);
}

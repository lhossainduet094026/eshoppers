package com.lokman.shoppingcart.repository;

import java.util.Optional;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.User;

public interface CartRepository {
	Optional<Cart> findByUser(User currentUser);

	Cart save(Cart cart);

	Cart update(Cart cart);
}

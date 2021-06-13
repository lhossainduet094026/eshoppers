package com.lokman.shoppingcart.repository;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.User;

public class CartRepositoryImpl implements CartRepository {
	private static final Map<User, Set<Cart>> CARTS = new ConcurrentHashMap();

	@Override
	public Optional<Cart> findByUser(User currentUser) {
		Set<Cart> carts = CARTS.get(currentUser);
		if (carts != null && !carts.isEmpty()) {
			Cart cart = (Cart) carts.toArray()[carts.size() - 1];
			return Optional.of(cart);
		}
		return Optional.empty();
	}

	@Override
	public Cart save(Cart cart) {
		CARTS.computeIfPresent(cart.getUser(), (user, carts) -> {
			carts.add(cart);
			return carts;
		});
		CARTS.computeIfAbsent(cart.getUser(), user -> {
			var carts = new LinkedHashSet<Cart>();
			carts.add(cart);
			return carts;
		});
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
//		CARTS.computeIfPresent(cart.getUser(), (user, carts) -> {
//			Cart[] objects = carts.toArray(Cart[]::new]);
//			
//			objects[objects.length - 1] = cart;
//			return new LinkedHashSet<>(Arrays.asList(objects));
//		});
		return cart;
	}

}

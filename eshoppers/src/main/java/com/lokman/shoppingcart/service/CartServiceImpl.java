package com.lokman.shoppingcart.service;

import java.util.Optional;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.repository.CartRepository;

public class CartServiceImpl implements CartService {
	private final CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart getCartByUser(User currentUser) {

		Optional<Cart> optionalCart = cartRepository.findByUser(currentUser);
		return optionalCart.orElseGet(()->createNewCart(currentUser));
	}
	private Cart createNewCart(User currentUser) {
		Cart cart = new Cart();
		cart.setUser(currentUser);
		return cartRepository.save(cart);
	}
	

}

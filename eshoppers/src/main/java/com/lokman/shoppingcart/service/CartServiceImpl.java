package com.lokman.shoppingcart.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.Product;
import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.repository.CartRepository;
import com.lokman.shoppingcart.repository.ProductRepository;

public class CartServiceImpl implements CartService {
	private final CartRepository cartRepository;
	private final ProductRepository productRepository = null;

	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart getCartByUser(User currentUser) {

		Optional<Cart> optionalCart = cartRepository.findByUser(currentUser);
		return optionalCart.orElseGet(() -> createNewCart(currentUser));
	}

	private Cart createNewCart(User currentUser) {
		Cart cart = new Cart();
		cart.setUser(currentUser);
		return cartRepository.save(cart);
	}

	public void addProductToCart(String productId, Cart cart) {
		if (productId == null || productId.length() == 0) {
			throw new IllegalArgumentException("Product id cannot be null");
		}
		Long id = parseProductId(productId);
		var product = (Product) productRepository.findById(id);
		if (product == null) {
			//throw new ProductNotFoundException("Product not found by id:" + id);
		}
		addProductToCart(product, cart);
		Integer totalTotalItem = getTotalItem(cart);
		BigDecimal totalPrice = calculateTotalPrice(cart);
		cart.setTotalItem(totalTotalItem);
		cart.setTotalPrice(totalPrice);
		cartRepository.update(cart);
	}

	private BigDecimal calculateTotalPrice(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getTotalItem(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	private Long parseProductId(String productId) {
		try {
			return Long.parseLong(productId);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Product id must be a number", ex);
		}
	}

private void addProductToCart(Product product,Cart cart) {
	
}
}

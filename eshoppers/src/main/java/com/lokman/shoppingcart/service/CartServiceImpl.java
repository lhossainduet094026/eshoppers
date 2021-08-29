package com.lokman.shoppingcart.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.CartItem;
import com.lokman.shoppingcart.domain.Product;
import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.repository.CartItemRepository;
import com.lokman.shoppingcart.repository.CartRepository;
import com.lokman.shoppingcart.repository.ProductRepository;
import com.lokman.shoppingcart.util.ProductNotFoundException;

public class CartServiceImpl implements CartService {
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private CartItemRepository cartItemRepository;

	public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository,
			ProductRepository productRepository) {
		this.cartRepository = cartRepository;
		this.cartItemRepository = cartItemRepository;
		this.productRepository = productRepository;
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

	private BigDecimal calculateTotalPrice(Cart cart) {
		BigDecimal totalPrice = new BigDecimal(0);
		Set<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {

			totalPrice = totalPrice.add(cartItem.getPrice());
		}
		return totalPrice;
	}

	private Integer getTotalItem(Cart cart) {
		int totalCartItem = 0;
		Set<CartItem> cartItemsSet = cart.getCartItems();
		for (CartItem cartItem : cartItemsSet) {
			totalCartItem += cartItem.getQuantity();
		}
		return totalCartItem;
	}

	private Long parseProductId(String productId) {
		try {
			return Long.parseLong(productId);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Product id must be a number", ex);
		}
	}

	private void addProductToCart(Product product, Cart cart) {
		CartItem existingCartItem = findSimilarProductInCart(cart, product);

		if (existingCartItem != null) {
			existingCartItem = increaseQuantityByOne(existingCartItem);
		} else {
			existingCartItem = null;
			existingCartItem = createNewCartItem(product);
		}
		cart.getCartItems().add(existingCartItem);
	}

	private CartItem findSimilarProductInCart(Cart cart, Product product) {
		Set<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			if (cartItem != null) {
				Product existingProduct = cartItem.getProduct();
				if (existingProduct.equals(product)) {
					return cartItem;
				}
			}

		}
		return null;
	}

	private CartItem createNewCartItem(Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setPrice(product.getPrice());
		return cartItemRepository.save(cartItem);
	}

	private CartItem increaseQuantityByOne(CartItem existingCartItem) {
		existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
		BigDecimal totalPrice = (existingCartItem.getProduct().getPrice())
				.multiply(BigDecimal.valueOf(existingCartItem.getQuantity()));

		existingCartItem.setPrice(totalPrice);

		return cartItemRepository.update(existingCartItem);
	}

	@Override
	public void addProductToCart(String productId, Cart cart) {
		if (productId == null || productId.length() == 0) {
			throw new IllegalArgumentException("Product id cannot be null");
		}
		Long id = parseProductId(productId);
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found by id:" + id));
		addProductToCart(product, cart);
		Integer totalTotalItem = getTotalItem(cart);
		BigDecimal totalPrice = calculateTotalPrice(cart);
		cart.setTotalItem(totalTotalItem);
		cart.setTotalPrice(totalPrice);
		cartRepository.update(cart);
		
	}

}

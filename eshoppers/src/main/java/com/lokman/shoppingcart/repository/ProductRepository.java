package com.lokman.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import com.lokman.shoppingcart.domain.Product;

public interface ProductRepository {
	public List<Product> findAllProducts();

	public Optional<Product> findById(Long productId);
}

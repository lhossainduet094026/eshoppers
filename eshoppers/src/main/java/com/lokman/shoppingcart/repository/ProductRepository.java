package com.lokman.shoppingcart.repository;

import java.util.List;

import com.lokman.shoppingcart.domain.Product;

public interface ProductRepository {
	public List<Product> findAllProducts();
}

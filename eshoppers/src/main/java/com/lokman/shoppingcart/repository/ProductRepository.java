package com.lokman.shoppingcart.repository;

import java.util.List;

import com.lokman.shoppingcart.dto.ProductDTO;

public interface ProductRepository {
	public List<ProductDTO> findAllProducts();
}

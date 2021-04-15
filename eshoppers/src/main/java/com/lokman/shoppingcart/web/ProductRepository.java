package com.lokman.shoppingcart.web;

import java.util.List;

public interface ProductRepository {
	public List<ProductDTO> findAllProducts();
}

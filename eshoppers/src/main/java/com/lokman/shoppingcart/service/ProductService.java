package com.lokman.shoppingcart.service;

import java.util.List;

import com.lokman.shoppingcart.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAllProductSortedByName();
}

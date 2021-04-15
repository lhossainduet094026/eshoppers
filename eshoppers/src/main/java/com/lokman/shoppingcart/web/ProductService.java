package com.lokman.shoppingcart.web;

import java.util.List;

public interface ProductService {
	List<ProductDTO> findAllProductSortedByName();
}

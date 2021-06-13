package com.lokman.shoppingcart.repository;

import java.math.BigDecimal;
import java.util.List;

import com.lokman.shoppingcart.domain.Product;

public class DummyProductRepositoryImpl implements ProductRepository {

	private static final List<Product> ALL_PRODUCTS = List.of(
			new Product(1L, "Apple ipad", "Apple ipad 10.2.32 GB", BigDecimal.valueOf(369.99)),
			new Product(2L, "Headphone", "jabra elite bluetooth headphone", BigDecimal.valueOf(249.99)),
			new Product(3L, "microsoft surface pro", "microsoft surface pro 128gb windows", BigDecimal.valueOf(799.99)),
			new Product(4L, "amazon echo dot", "amazon echo dot 3rd generation with alexa", BigDecimal.valueOf(34.99)));

	@Override
	public List<Product> findAllProducts() {
		return ALL_PRODUCTS;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

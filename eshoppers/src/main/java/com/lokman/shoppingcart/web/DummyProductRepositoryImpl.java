package com.lokman.shoppingcart.web;

import java.math.BigDecimal;
import java.util.List;

public class DummyProductRepositoryImpl implements ProductRepository {

	@Override
	public List<ProductDTO> findAllProducts() {
		return List.of(
				new ProductDTO("Apple ipad","apple ipad 10.2 32gb",BigDecimal.valueOf(129.99)),
				new ProductDTO("Headphone","skull candy 10.2 32gb",BigDecimal.valueOf(300.99))
				);
		
	}

}

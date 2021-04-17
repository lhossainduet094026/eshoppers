package com.lokman.shoppingcart.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.lokman.shoppingcart.dto.ProductDTO;
import com.lokman.shoppingcart.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDTO> findAllProductSortedByName() {
		return productRepository.findAllProducts().stream().sorted(Comparator.comparing(ProductDTO::getName))
				.collect(Collectors.toList());
	}

}

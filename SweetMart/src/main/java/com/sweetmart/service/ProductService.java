package com.sweetmart.service;

import com.sweetmart.model.Product;

public interface ProductService {

	public Product addProduct(String key,Product product);
	
	public Product updateProduct(String key,Product product);
	
	public Product deleteProductById(String key, Integer productId);
}

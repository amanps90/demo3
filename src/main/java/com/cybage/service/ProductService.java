package com.cybage.service;

import java.util.List;

import com.cybage.pojo.Product;

public interface ProductService {
	void displayAllService();
	void addProductService(Product newProduct);
	void removeProductService(int id);
	void updateProductService(Product updateProduct);
	List<Product> getAllProductsService();
}

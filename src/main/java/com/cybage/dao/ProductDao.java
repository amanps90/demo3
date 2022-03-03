package com.cybage.dao;

import java.util.List;

import com.cybage.pojo.Product;

public interface ProductDao {
	void addProduct(String name,int price);
	void removeProductById(int id);
	void updateProdcuctById(int id,String name,int price);
	void displayAllProducts();
	List<Product> getAllProducts();
}

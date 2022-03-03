package com.cybage.service;

import java.util.List;

import com.cybage.dao.ProdcutDaoImplementation;
import com.cybage.dao.ProductDao;
import com.cybage.pojo.Product;

public class ProductServiceImplementation implements ProductService {
	ProductDao productDao = new ProdcutDaoImplementation();
	@Override
	public void displayAllService() {
		productDao.displayAllProducts();

	}

	@Override
	public void addProductService(Product newProduct) {
		
		productDao.addProduct( newProduct.getName(), newProduct.getPrice());

	}

	@Override
	public void removeProductService(int id) {
		productDao.removeProductById(id);

	}

	@Override
	public void updateProductService(Product updateProduct) {
		productDao.updateProdcuctById(updateProduct.getId(), updateProduct.getName(), updateProduct.getPrice());
	}

	@Override
	public List<Product> getAllProductsService() {
		
		return productDao.getAllProducts();
	}

}

package com.cybage.main;

import java.util.List;
import java.util.Scanner;

import com.cybage.pojo.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImplementation;

public class ProjectManagement {
	 static ProductService newService = new ProductServiceImplementation();

	public static void main(String[] args) {
		System.out.println("Welcome to product management System");
		try(Scanner scan = new Scanner(System.in)){
			
			System.out.println("1. Add a product");
			System.out.println("2. Delete a product");
			System.out.println("3. Update a product");
			System.out.println("4. Show all product");
			System.out.println("Please select an option");
			
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter name of product");
				String name = scan.next();
				scan.nextLine();
				System.out.println("Enter price");
				int price = scan.nextInt();
				Product newProduct = new Product(name, price);
				newService.addProductService(newProduct);
				break;
			
			case 2:
				System.out.println("Enter id of product");
				int id = scan.nextInt();				
				newService.removeProductService(id);
				break;	
				
			case 3:
				System.out.println("Enter id of product to update");
				int id2 = scan.nextInt();
				System.out.println("Enter new name for product");
				String newName = scan.next();
				scan.nextLine();
				System.out.println("Enter new price for product");
				int newPrice = scan.nextInt();
				Product updateProduct = new Product(newName,newPrice);
				updateProduct.setId(id2);
				newService.updateProductService(updateProduct);
				break;	
				
			case 4:
				System.out.println("**************All Products*****************");
				List<Product> allproduct = newService.getAllProductsService();
				allproduct.forEach(System.out::println);
				break;
			}
			
				
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.cybage.dao;
import static com.cybage.utility.jdbcUtility.getConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cybage.pojo.Product;

public class ProdcutDaoImplementation implements ProductDao {
		
	@Override
	public void addProduct(String name, int price){
		Connection connection = getConnection();
		try(connection) {
			PreparedStatement preStatement = connection.prepareStatement("insert into product_details(name,price) values(?,?)");
			preStatement.setString(1,name);
			preStatement.setInt(2,price);
			int update= preStatement.executeUpdate();
			if(update==1) {
				System.out.println("product added successfully!");
			}
			else {
				System.err.println("Some error occured could not perform operation");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeProductById(int id) {
		Connection connection = getConnection();
		try(connection) {
			Statement statement = connection.createStatement();
			int update = statement.executeUpdate("delete from product_details where id="+id);
			if(update==1) {
				System.out.println("product deleted successfully!");
			}
			else {
				System.err.println("Some error occured could not perform operation");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void updateProdcuctById(int id,String name,int price) {
		Connection connection = getConnection();
		
		try(connection) {
			PreparedStatement preStatement = connection.prepareStatement("update product_details set name=?,price=? where id=?");
			preStatement.setString(1, name);
			preStatement.setInt(2, price);
			preStatement.setInt(3, id);
			int update= preStatement.executeUpdate();
			if(update==1) {
				System.out.println("product updated successfully!");
			}
			else {
				System.err.println("Some error occured could not perform operation");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void displayAllProducts() {
		Connection connection = getConnection();
		
		try(connection) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from product_details");
			
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int price = result.getInt(3);
				System.out.println("Id:"+id+" Name:"+name+" Price:"+price);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		Connection connection = getConnection();
		
		try(connection) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from product_details");
			
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int price = result.getInt(3);
				Product product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				list.add(product);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

}

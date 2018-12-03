package DAO;

import java.util.ArrayList;

import JavaBean.Product;

public interface ProductDAO 
{
	
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our Product class
	 */
	
	public ArrayList<Product> getAllProducts();
	public Product getProduct(int prod_Id);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public void createProduct(Product product);
}

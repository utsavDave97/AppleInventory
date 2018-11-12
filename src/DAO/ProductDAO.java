package DAO;

import java.util.ArrayList;

import JavaBean.Product;

public interface ProductDAO 
{
	public ArrayList<Product> getAllProducts();
	public Product getProduct(int prod_Id);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public void createProduct(Product product);
}

package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ProductDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Product;
import javafx.collections.FXCollections;

public class ProductTable implements ProductDAO 
{
	
	DBConnection db = DBConnection.getInstance();
	ArrayList<Product> products;

	@Override
	public ArrayList<Product> getAllProducts() 
	{
		String query = "SELECT * FROM " + Const.TABLE_PRODUCT;
		products = new ArrayList<Product>();
		
		try
		{
			Statement getProducts = db.getDbConnection().createStatement();
			ResultSet data = getProducts.executeQuery(query);
			
			while(data.next())
			{
				products.add(new Product(data.getInt(Const.PRODUCT_COLUMN_ID),
						   data.getString(Const.PRODUCT_COLUMN_NAME),
						   data.getString(Const.PRODUCT_COLUMN_PRICE),
						   data.getString(Const.PRODUCT_COLUMN_TASTE)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product getProduct(int prod_Id) 
	{
		String query = "SELECT FROM " + Const.TABLE_PRODUCT + " WHERE " +
				   Const.PRODUCT_COLUMN_ID + " = " + prod_Id;
		Product product = new Product();
		try 
		{
			Statement getProduct = db.getDbConnection().createStatement();
			ResultSet data = getProduct.executeQuery(query);
			data.next();
			product = new Product(data.getInt(Const.PRODUCT_COLUMN_ID),
					   data.getString(Const.PRODUCT_COLUMN_NAME),
					   data.getString(Const.PRODUCT_COLUMN_PRICE),
					   data.getString(Const.PRODUCT_COLUMN_TASTE));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return product;
	}

	public int getProductID(String typeName, String price)
	{
		int id = 0;
		
		String query = "SELECT " + Const.PRODUCT_COLUMN_ID + " FROM " + Const.TABLE_PRODUCT
						+ " WHERE " + Const.PRODUCT_COLUMN_NAME + " = '" + typeName + "' AND "
						+ Const.PRODUCT_COLUMN_PRICE + " = '" + price +"';";
		
		try
		{
			Statement getStock = db.getDbConnection().createStatement();
			ResultSet data = getStock.executeQuery(query);
			
			data.next();
			id = data.getInt(Const.PRODUCT_COLUMN_ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return id;
	}
	
	@Override
	public void updateProduct(Product product) 
	{
		String query = "UPDATE " + Const.TABLE_PRODUCT + " SET " +
		         Const.PRODUCT_COLUMN_NAME + "='" + product.getProd_name() +  "' ," +
		         Const.PRODUCT_COLUMN_PRICE + "='" + product.getProd_price() +  "' " +
		         " WHERE " + Const.PRODUCT_COLUMN_ID + " = " + product.getProd_Id();
		try 
		{
			Statement updateProduct = db.getDbConnection().createStatement();
			updateProduct.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) 
	{
		
	}

	@Override
	public void createProduct(Product product) 
	{
		String query = "INSERT INTO " + Const.TABLE_PRODUCT +
				   "(" + Const.PRODUCT_COLUMN_NAME + ", " +
				   Const.PRODUCT_COLUMN_PRICE + "," +
				   Const.PRODUCT_COLUMN_TASTE + ") VALUES ('" +
				   product.getProd_name() + "','" + product.getProd_price() + "','" + 
				   product.getProd_taste() + "');";
		
		try 
		{
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted Record");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

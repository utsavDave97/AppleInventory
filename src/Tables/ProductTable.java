package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ProductDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Product;

public class ProductTable implements ProductDAO 
{
	//create an instance of the Dbconnection
	DBConnection db = DBConnection.getInstance();
	//create an arraylist for the Product class
	ArrayList<Product> products;

	@Override
	public ArrayList<Product> getAllProducts() 
	{
		//create a query for the DB
		String query = "SELECT * FROM " + Const.TABLE_PRODUCT;
		//create a new arrayList for the product class
		products = new ArrayList<Product>();
		
		try
		{
			//create a statement and attach it to the global DB.
			Statement getProducts = db.getDbConnection().createStatement();
			//grab the data returned inside the query
			ResultSet data = getProducts.executeQuery(query);
			
			//if data has next then do this
			while(data.next())
			{
				//add the product into the DB
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
		//create a query for the DB
		String query = "SELECT * FROM " + Const.TABLE_PRODUCT + " WHERE " +
				   Const.PRODUCT_COLUMN_ID + " = " + prod_Id;
		//create a new product object
		Product product = new Product();
		try 
		{
			//create a statement connected to the DB
			Statement getProduct = db.getDbConnection().createStatement();
			//create a resultset to grab the information for the db
			ResultSet data = getProduct.executeQuery(query);
			//set the cursor to the next info
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
		//create a query for the DB
		String query = "SELECT " + Const.PRODUCT_COLUMN_ID + " FROM " + Const.TABLE_PRODUCT
						+ " WHERE " + Const.PRODUCT_COLUMN_NAME + " = '" + typeName + "' AND "
						+ Const.PRODUCT_COLUMN_PRICE + " = '" + price +"';";
		
		try
		{
			//create a statement connected to the DB
			Statement getStock = db.getDbConnection().createStatement();
			//create a resultset to grab the information for the db
			ResultSet data = getStock.executeQuery(query);
			
			data.next();
			//set the value of ID to the id column
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
		//create a query
		String query = "UPDATE " + Const.TABLE_PRODUCT + " SET " +
		         Const.PRODUCT_COLUMN_NAME + "='" + product.getProd_name() +  "' ," +
		         Const.PRODUCT_COLUMN_PRICE + "='" + product.getProd_price() +  "' , " +
		         Const.PRODUCT_COLUMN_TASTE + "='" + product.getProd_taste() +  "' " +
		         " WHERE " + Const.PRODUCT_COLUMN_ID + " = " + product.getProd_Id();
		try 
		{
			//create a statement connected to the DB
			Statement updateProduct = db.getDbConnection().createStatement();
			//execute the query
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
		//create a query
		String query  = "DELETE FROM " + Const.TABLE_PRODUCT + " WHERE " +
				Const.PRODUCT_COLUMN_ID + " = " + product.getProd_Id();
		try 
		{
			//execute the query
			db.getDbConnection().createStatement().execute(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createProduct(Product product) 
	{
		//create a query
		String query = "INSERT INTO " + Const.TABLE_PRODUCT +
				   "(" + Const.PRODUCT_COLUMN_NAME + ", " +
				   Const.PRODUCT_COLUMN_PRICE + "," +
				   Const.PRODUCT_COLUMN_TASTE + ") VALUES ('" +
				   product.getProd_name() + "','" + product.getProd_price() + "','" + 
				   product.getProd_taste() + "');";
		
		try 
		{	
			//execute the table
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted Record");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String grabProductName(int prod_id) {
		
		//create the query
		String USER_LOGIN_SCRIPT = "SELECT "+ Const.PRODUCT_COLUMN_NAME +" FROM "
				+ Const.TABLE_PRODUCT +" WHERE " + Const.PRODUCT_COLUMN_ID +" = "+ "'"+ prod_id+"'"+" LIMIT 1 ";
		
		String productName = null;
		//System.out.println(USER_LOGIN_SCRIPT);

		try {
			//create a dbconnection object
			DBConnection db = DBConnection.getInstance();
			//create a preparedstatement
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			//exeucte the statement
			ResultSet pass = preparedStatement.executeQuery();
			

			if(pass != null) {
				if(pass.next()) {
					
					productName = pass.getString("prod_name");
					//System.out.println(productName);
					return productName;

				}
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return null;
	}
}

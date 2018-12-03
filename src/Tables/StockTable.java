package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.StockDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Product;
import JavaBean.Stock;

public class StockTable implements StockDAO 
{
	//get the instance of DB
	DBConnection db = DBConnection.getInstance();
	//create an arrayList of the Stock class
	ArrayList<Stock> stocks;

	@Override
	public ArrayList<Stock> getAllStocks() 
	{
		//create the sql query
		String query = "SELECT * FROM " + Const.TABLE_STOCK;
		//create a new arrayList
		stocks = new ArrayList<Stock>();

		try
		{
			//create a statement
			Statement getStocks = db.getDbConnection().createStatement();
			//execute the resultset on the query
			ResultSet data = getStocks.executeQuery(query);

			while(data.next())
			{
				stocks.add(new Stock(data.getInt(Const.STOCK_COLUMN_ID),
						data.getInt(Const.STOCK_COLUMN_QUANTITY)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return stocks;
	}

	@Override
	public Stock getStock(int id) 
	{
		//create the sql query
		String query = "SELECT * FROM " + Const.TABLE_STOCK + " WHERE " +
				Const.STOCK_COLUMN_ID + " = " + id;
		Stock stock = new Stock();
		try 
		{
			//prepare the query
			Statement getStock = db.getDbConnection().createStatement();
			//execute
			ResultSet data = getStock.executeQuery(query);
			data.next();
			stock = new Stock(data.getInt(Const.STOCK_COLUMN_ID),
					data.getInt(Const.STOCK_COLUMN_QUANTITY));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return stock;
	}

	public int getStockID(int prodID, int quantity)
	{
		int id = 0;
		//create a query
		String query = "SELECT " + Const.STOCK_COLUMN_ID + " FROM " + Const.TABLE_STOCK
				+ " WHERE " + Const.STOCK_COLUMN_QUANTITY + " = '" + quantity + "' AND "
				+ Const.STOCK_COLUMN_ID + " = '" + prodID +"';";

		try
		{
			//prepare the query
			Statement getStock = db.getDbConnection().createStatement();
			//execute
			ResultSet data = getStock.executeQuery(query);

			data.next();
			id = data.getInt(Const.STOCK_COLUMN_ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public void updateStock(Stock stock) 
	{
		//create a query
		String query = "UPDATE " + Const.TABLE_STOCK + " SET " +
				Const.STOCK_COLUMN_QUANTITY + "='" + stock.getProd_qty() +  "' " +
				" WHERE " + Const.STOCK_COLUMN_ID + " = " + stock.getProd_Id();
		try 
		{
			//prepare the query
			Statement updateStock = db.getDbConnection().createStatement();
			//execute the query
			updateStock.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStock(Stock stock) 
	{	
		//create the sql query
		String query  = "UPDATE " + Const.TABLE_STOCK + " SET " +
				Const.STOCK_COLUMN_QUANTITY + " = 0" + " WHERE " + Const.STOCK_COLUMN_ID +
				" = " + stock.getProd_Id();
		try 
		{
			//get the instance of DB
			db.getDbConnection().createStatement().execute(query);
			//System.out.println("Deleted record");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createStock(Stock stock) 
	{
		//create the sql query
		String	query	 = "INSERT INTO " + Const.TABLE_STOCK + 
				"(" + Const.STOCK_COLUMN_ID + "," +
				Const.STOCK_COLUMN_QUANTITY + ") VALUES (LAST_INSERT_ID(), ('" +
				stock.getProd_qty() + "')); ";


		try 
		{
			//execute the statement
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

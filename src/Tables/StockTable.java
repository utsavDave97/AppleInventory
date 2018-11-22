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
	DBConnection db = DBConnection.getInstance();
	ArrayList<Stock> stocks;
	
	@Override
	public ArrayList<Stock> getAllStocks() 
	{
		String query = "SELECT * FROM " + Const.TABLE_STOCK;
		stocks = new ArrayList<Stock>();
		
		try
		{
			Statement getStocks = db.getDbConnection().createStatement();
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
		String query = "SELECT FROM " + Const.TABLE_STOCK + " WHERE " +
				   Const.STOCK_COLUMN_ID + " = " + id;
		Stock stock = new Stock();
		try 
		{
			Statement getStock = db.getDbConnection().createStatement();
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
		
		String query = "SELECT " + Const.STOCK_COLUMN_ID + " FROM " + Const.TABLE_STOCK
						+ " WHERE " + Const.STOCK_COLUMN_QUANTITY + " = '" + quantity + "' AND "
						+ Const.STOCK_COLUMN_ID + " = '" + prodID +"';";
		
		try
		{
			Statement getStock = db.getDbConnection().createStatement();
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
		String query = "UPDATE " + Const.TABLE_STOCK + " SET " +
		         Const.STOCK_COLUMN_QUANTITY + "='" + stock.getProd_qty() +  "' " +
		         " WHERE " + Const.STOCK_COLUMN_ID + " = " + stock.getProd_Id();
		try 
		{
			Statement updateStock = db.getDbConnection().createStatement();
			updateStock.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createStock(Stock stock) 
	{
		String	query	 = "INSERT INTO " + Const.TABLE_STOCK + 
				   "(" + Const.STOCK_COLUMN_ID + "," +
				   	 Const.STOCK_COLUMN_QUANTITY + ") VALUES (LAST_INSERT_ID(), ('" +
				   	stock.getProd_qty() + "')); ";
		
		
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

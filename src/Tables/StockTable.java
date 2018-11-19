package Tables;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.StockDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Stock;

public class StockTable implements StockDAO 
{
	DBConnection db = DBConnection.getInstance();

	@Override
	public ArrayList<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStock(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		
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

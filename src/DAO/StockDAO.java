package DAO;

import java.util.ArrayList;

import JavaBean.Stock;

public interface StockDAO 
{
	
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our Stock class
	 */
	
	public ArrayList<Stock> getAllStocks();
	public Stock getStock(int id);
	public void updateStock(Stock stock);
	public void deleteStock(Stock stock);
	public void createStock(Stock stock);
}

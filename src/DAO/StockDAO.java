package DAO;

import java.util.ArrayList;

import JavaBean.Stock;

public interface StockDAO 
{
	public ArrayList<Stock> getAllStocks();
	public Stock getStock(int id);
	public void updateStock(Stock stock);
	public void deleteStock(Stock stock);
	public void createStock(Stock stock);
}

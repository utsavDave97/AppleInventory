package DAO;

import java.util.ArrayList;

import JavaBean.Sale;

public interface SaleDAO 
{
	public ArrayList<Sale> getAllSales();
	public Sale getSale(int id);
	public void updateSale(Sale sale);
	public void deleteSale(Sale sale);
	public void createSale(Sale sale);
}

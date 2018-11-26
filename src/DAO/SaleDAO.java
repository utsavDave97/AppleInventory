package DAO;

import java.util.ArrayList;

import JavaBean.Sale;

public interface SaleDAO 
{
	public ArrayList<Sale> getAllSales();
	public Sale getSale(int id);
	public void updateSale(Sale sale,int email_id,double tax,double total,String sale_time);
	public void deleteSale(Sale sale);
	public int createSale(Sale sale);
	
}

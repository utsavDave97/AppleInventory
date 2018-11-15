package DAO;

import java.util.ArrayList;

import JavaBean.SaleItem;

public interface SaleItemDAO 
{
	
	public ArrayList<SaleItem> getAllSaleItems();
	public SaleItem getSaleItem(int id);
	public void updateSaleItem(SaleItem saleItem);
	public void deleteSaleItem(SaleItem saleItem);
	public void createSaleItem(SaleItem saleItem);

}

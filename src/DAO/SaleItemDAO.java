package DAO;

import java.util.ArrayList;

import JavaBean.SaleItem;

public interface SaleItemDAO 
{
	
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our SaleItem class
	 */
	
	public ArrayList<SaleItem> getAllSaleItems();
	public SaleItem getSaleItem(int prodId,int saleId);
	public void updateSaleItem(SaleItem saleItem);
	public void deleteSaleItem(SaleItem saleItem);
	public void createSaleItem(SaleItem saleItem);

}

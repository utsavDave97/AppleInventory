package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import DAO.SaleItemDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Sale;
import JavaBean.SaleItem;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class SaleItemTable implements SaleItemDAO {

	ArrayList<SaleItem> saleItems;	   
	DBConnection db = DBConnection.getInstance();
	
	@Override
	public ArrayList<SaleItem> getAllSaleItems() {
		String query = "SELECT * FROM " + Const.TABLE_SALE_ITEM;
		saleItems= new ArrayList<SaleItem>();
	
		try
		{
			Statement getSales = db.getDbConnection().createStatement();
			ResultSet data = getSales.executeQuery(query);
			
			while(data.next())
			{
				saleItems.add(
						new SaleItem(
								data.getInt(Const.SALE_ITEM_COLUMN_PROD_ID),
								data.getInt(Const.SALE_ITEM_COLUMN_SALE_ID),
								data.getInt(Const.SALE_ITEM_COLUMN_QUANTITY)
						));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return saleItems;
	}

	@Override
	public SaleItem getSaleItem(int prodId, int saleId) {
		SaleItem saleItem=null;				
		String query = "SELECT * FROM " + Const.TABLE_SALE_ITEM+" WHERE  `"+Const.SALE_ITEM_COLUMN_SALE_ID+"`="+saleId+
				"  AND `"+Const.SALE_ITEM_COLUMN_PROD_ID+"`="+prodId;
		
		try {

			Statement getSaleItem=db.getDbConnection().createStatement();
			ResultSet data=getSaleItem.executeQuery(query);
			data.next();
		
		 saleItem=new SaleItem(
					data.getInt(Const.SALE_ITEM_COLUMN_PROD_ID),
					data.getInt(Const.SALE_ITEM_COLUMN_SALE_ID),
					data.getInt(Const.SALE_ITEM_COLUMN_QUANTITY)
			     );
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return saleItem;
	}

	@Override
	public void updateSaleItem(SaleItem saleItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSaleItem(SaleItem saleItem) {
		String query="DELETE FROM "+Const.TABLE_SALE_ITEM+
				" WHERE "+Const.SALE_ITEM_COLUMN_PROD_ID + "="+saleItem.getProd_Id()+
				"  AND "+Const.SALE_ITEM_COLUMN_SALE_ID+"="+saleItem.getSale_Id();
				
		try {	
			Statement deleteSale=db.getDbConnection().createStatement();
		
		   deleteSale.executeUpdate(query);
		   
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void createSaleItem(SaleItem saleItem) {
		String query = "INSERT INTO " + Const.TABLE_SALE_ITEM +
				   "(" + Const.SALE_ITEM_COLUMN_PROD_ID + "," +
				   Const.SALE_ITEM_COLUMN_SALE_ID + "," +
				   Const.SALE_ITEM_COLUMN_QUANTITY + ") VALUES (" +
				   saleItem.getProd_Id() + "," + saleItem.getSale_Id() + "," + 
				  saleItem.getSale_qty() + ");";
		
		try 
		{
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted sale Item Record");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int grabSalePerItem(int prod_id) {
		String USER_LOGIN_SCRIPT = "SELECT * FROM "+ Const.TABLE_SALE_ITEM +" WHERE "
				+ Const.SALE_ITEM_COLUMN_PROD_ID +" = "+ "'"+ prod_id+"'";
		
		int quantTot = 0;

		try {
			//System.out.println(USER_LOGIN_SCRIPT);
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			//System.out.println(USER_LOGIN_SCRIPT);
			if(pass != null) {
				while(pass.next()) {
					quantTot += pass.getInt("sale_qty");
				}				
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		
		return quantTot;
	}
	
	public int grabAllSoldProdId() {
		String USER_LOGIN_SCRIPT = "SELECT DISTINCT "+ Const.SALE_ITEM_COLUMN_PROD_ID +" FROM "
				+ Const.TABLE_SALE_ITEM;
		int i = 0;

		//SELECT DISTINCT prod_id FROM sale_item
		try {
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			
			if(pass != null) {
				while(pass.next()) {
					i++;
				}
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	public Data addPieData(int prod_id) {
		//create two new connections to the requried tables
		ProductTable productTable = new ProductTable();
		SaleItemTable saleitemtable = new SaleItemTable();
		
		
		
		return new PieChart.Data(productTable.grabProductName(prod_id), saleitemtable.grabSalePerItem(prod_id));

	}
}

package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DAO.SaleItemDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Sale;
import JavaBean.SaleItem;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class SaleItemTable implements SaleItemDAO {
	//create a new arraylist for the saleitem class
	ArrayList<SaleItem> saleItems;	   
	//create a dbconnection
	DBConnection db = DBConnection.getInstance();

	@Override
	public ArrayList<SaleItem> getAllSaleItems() {
		//create a query
		String query = "SELECT * FROM " + Const.TABLE_SALE_ITEM;
		saleItems= new ArrayList<SaleItem>();

		try
		{
			//create a sql statement
			Statement getSales = db.getDbConnection().createStatement();
			//execute the data from a resultset
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
		//create an query
		String query = "SELECT * FROM " + Const.TABLE_SALE_ITEM+" WHERE  `"+Const.SALE_ITEM_COLUMN_SALE_ID+"`="+saleId+
				"  AND `"+Const.SALE_ITEM_COLUMN_PROD_ID+"`="+prodId;

		try {
			//create a sql statement
			Statement getSaleItem=db.getDbConnection().createStatement();
			//execute the data from a resultset
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
		//create a query
		String query="DELETE FROM "+Const.TABLE_SALE_ITEM+
				" WHERE "+Const.SALE_ITEM_COLUMN_PROD_ID + "="+saleItem.getProd_Id()+
				"  AND "+Const.SALE_ITEM_COLUMN_SALE_ID+"="+saleItem.getSale_Id();

		try {	
			//grab the instance of the dbconnection
			Statement deleteSale=db.getDbConnection().createStatement();

			//execute the query
			deleteSale.executeUpdate(query);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void createSaleItem(SaleItem saleItem) {
		//create a query
		String query = "INSERT INTO " + Const.TABLE_SALE_ITEM +
				"(" + Const.SALE_ITEM_COLUMN_PROD_ID + "," +
				Const.SALE_ITEM_COLUMN_SALE_ID + "," +
				Const.SALE_ITEM_COLUMN_QUANTITY + ") VALUES (" +
				saleItem.getProd_Id() + "," + saleItem.getSale_Id() + "," + 
				saleItem.getSale_qty() + ");";

		try 
		{
			//get the instance of DB
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
		//create a query
		String USER_LOGIN_SCRIPT = "SELECT * FROM "+ Const.TABLE_SALE_ITEM +" WHERE "
				+ Const.SALE_ITEM_COLUMN_PROD_ID +" = "+ "'"+ prod_id+"'";

		int quantTot = 0;

		try {
			//System.out.println(USER_LOGIN_SCRIPT);
			//get the instance of DB
			DBConnection db = DBConnection.getInstance();
			//prepare the query
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			//execute
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
		//create a query
		String USER_LOGIN_SCRIPT = "SELECT DISTINCT "+ Const.SALE_ITEM_COLUMN_PROD_ID +" FROM "
				+ Const.TABLE_SALE_ITEM;
		int i = 0;

		//SELECT DISTINCT prod_id FROM sale_item
		try {
			//get the instance of DB
			DBConnection db = DBConnection.getInstance();
			//prepare the query
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			//execute
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

	public void deleteSomeSaleItems(int saleId) {

		//create a query
		String query="DELETE FROM "+Const.TABLE_SALE_ITEM+
				" WHERE "+ Const.SALE_ITEM_COLUMN_SALE_ID+" = "+saleId;

		try
		{
			//create a statement
			Statement getSaleItems = db.getDbConnection().createStatement();
			//execute the query
			getSaleItems.executeUpdate(query);


		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}

package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DAO.SaleDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Sale;
/**
 * @description This class mainly for sale table operation, including insert,delete update,query
 * @author wang
 *
 */

public class SaleTable implements SaleDAO {

	//get the instance of DB
	DBConnection db = DBConnection.getInstance();
	//create a new arraylist for the user class
	ArrayList<Sale> saleLists;

	@Override
	public ArrayList<Sale> getAllSales() {
		//create a query
		String query = "SELECT * FROM " + Const.TABLE_SALE;
		saleLists = new ArrayList<Sale>();



		try
		{
			//get the instance of DB
			Statement getSales = db.getDbConnection().createStatement();
			//execute the query
			ResultSet data = getSales.executeQuery(query);

			while(data.next())
			{
				saleLists.add(
						new Sale(
								data.getInt(Const.SALE_COLUMN_ID),
								data.getInt(Const.SALE_COLUMN_EMAIL_ID),
								data.getDouble(Const.SALE_COLUMN_TAX),
								data.getDouble(Const.SALE_COLUMN_TOTAL),
								data.getString(Const.SALE_COLUMN_TIME))
						);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}



		return saleLists;
	}

	@Override
	public Sale getSale(int id) {
		Sale sale=null;
		//create a query
		String query = "SELECT * FROM " + Const.TABLE_SALE+" WHERE  `"+Const.SALE_COLUMN_ID+"`="+id;

		try {
			//create the statement
			Statement getOnsale=db.getDbConnection().createStatement();
			//execute the query on the resultset
			ResultSet data=getOnsale.executeQuery(query);
			data.next();
			sale=new Sale(data.getInt(Const.SALE_COLUMN_ID),
					data.getInt(Const.SALE_COLUMN_EMAIL_ID),
					data.getDouble(Const.SALE_COLUMN_TAX),
					data.getDouble(Const.SALE_COLUMN_TOTAL),
					data.getString(Const.SALE_COLUMN_TIME));

		}
		catch (Exception e) {
			e.printStackTrace();
		}



		return sale;
	}

	@Override
	public void updateSale(Sale sale,int email_id,double tax,double total,String sale_time) {
		//create a query
		String query = "UPDATE " + Const.TABLE_SALE + " SET " +
				Const.SALE_COLUMN_EMAIL_ID + "=" + email_id +  "," +
				Const.SALE_COLUMN_TAX + "=" + tax +  "," +
				Const.SALE_COLUMN_TOTAL + "="+total+","+
				Const.SALE_COLUMN_TIME  + "='"+sale_time+"'"+
				" WHERE " + Const.SALE_COLUMN_ID+ " = " + sale.getSale_Id();
		System.out.println(query);
		try 
		{
			//create the statement for the query
			Statement updateProduct = db.getDbConnection().createStatement();
			//execute the update for the table
			updateProduct.executeUpdate(query);
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}

	@Override
	public void deleteSale(Sale sale) {
		//create the SQL query 
		String query="DELETE FROM "+Const.TABLE_SALE+
				" WHERE "+Const.SALE_COLUMN_ID+"="+sale.getSale_Id();

		try {	Statement deleteSale=db.getDbConnection().createStatement();

		deleteSale.execute(query);
		System.out.println("delete sale successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}


	/**
	 * When we Create sale record in sale table, after that, grab the return id as other table (sale_item) reference to insert
	 * sale items
	 */


	@Override
	public int createSale(Sale sale) {
		//Initialize the new inserted id with -1;
		int returnedInsertId=-1;
		
		//create the sql query
		String query = "INSERT INTO " + Const.TABLE_SALE +
				"(" + Const.SALE_COLUMN_EMAIL_ID + ", " +
				Const.SALE_COLUMN_TAX + "," +
				Const.SALE_COLUMN_TOTAL +","+
				Const.SALE_COLUMN_TIME+") VALUES (" +
				sale.getEmail_id() + "," + sale.getTax() + "," + 
				sale.getTotal() + ",'"+
				sale.getSale_time()+"');";

		try 
		{
			//get the instance of DB
			Statement insertSale=db.getDbConnection().createStatement();
			//execute
			insertSale.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = insertSale.getGeneratedKeys();
			rs.next();
			returnedInsertId=rs.getInt(1);

			System.out.println("Inserted sale Record successfully!Id===="+ returnedInsertId);
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return returnedInsertId;
	}




}

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
	
   
	DBConnection db = DBConnection.getInstance();
	ArrayList<Sale> saleLists;
	
	@Override
	public ArrayList<Sale> getAllSales() {
		String query = "SELECT * FROM " + Const.TABLE_SALE;
		saleLists = new ArrayList<Sale>();
		

		
		try
		{
			Statement getSales = db.getDbConnection().createStatement();
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
		Sale sale=null;				;
		String query = "SELECT * FROM " + Const.TABLE_SALE+" WHERE  `"+Const.SALE_COLUMN_ID+"`="+id;
		
		try {
		Statement getOnsale=db.getDbConnection().createStatement();
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
		String query = "UPDATE " + Const.TABLE_SALE + " SET " +
		         Const.SALE_COLUMN_EMAIL_ID + "=" + email_id +  "," +
		         Const.SALE_COLUMN_TAX + "=" + tax +  "," +
		         Const.SALE_COLUMN_TOTAL + "="+total+","+
		         Const.SALE_COLUMN_TIME  + "='"+sale_time+"'"+
		         " WHERE " + Const.SALE_COLUMN_ID+ " = " + sale.getSale_Id();
		System.out.println(query);
		try 
		{
			Statement updateProduct = db.getDbConnection().createStatement();
			updateProduct.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteSale(Sale sale) {
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
			Statement insertSale=db.getDbConnection().createStatement();
			
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

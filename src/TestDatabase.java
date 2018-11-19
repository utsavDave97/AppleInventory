import Database.DBConnection;
import JavaBean.Product;
import Tables.ProductTable;

public class TestDatabase {
/**
 * @description This class just for test the database connection and all our slq script here.
 *               This class mainly test all the DAO's classes to make sure they work well.
  *              After development , this class will be deleted
 * @param args
 */
	public static void main(String[] args) 
	{
		DBConnection dabase;
		
		dabase= DBConnection.getInstance();
	}

}

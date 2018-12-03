import java.util.ArrayList;

import Database.DBConnection;
import Database.ReadCredential;
import JavaBean.Stock;
import JavaBean.User;
import Tables.StockTable;
import Tables.UserRoleTable;
import Tables.UserTable;


public class TestDatabase {
/**
 * @description This class just for test the database connection and all our slq script here.
 *               This class mainly test all the DAO's classes to make sure they work well.
  *              After development , this class will be deleted
 * @param args
 */
	public static void main(String[] args) 
	{
//		DBConnection dabase;
//		
//		dabase= DBConnection.getInstance();
	ReadCredential readCredential=new ReadCredential();
	System.out.println(readCredential.getDbName());
	System.out.println(readCredential.getDbPassword());
	System.out.println(readCredential.getWantInitialize());
		
	readCredential.WriteCredential("pma", "pma", "AppleInventory", "yes","192.168.64.2");
	
	}

}

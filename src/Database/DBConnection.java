package Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - Description:
 * @author wjqcau
 *
 */
public class DBConnection 
{
	private static DBConnection instance = null;
	private static Connection dbConnection=null;
	private Statement statement=null;
	
	/**
	 * Description: Using ReadCredential class to read database credential file, 
	 *             then Initialize database connection
	 * @return void
	 * @throws ClassNotFoundException
	 */
	private DBConnection() throws ClassNotFoundException
	{
		ReadCredential dbCredential=new ReadCredential();
		
		if(dbConnection == null)
		{
			try 
			{
				 //Load class
				 Class.forName(dbCredential.getDbDriver());
				 
				 //Initializing dbconnection
				dbConnection= (Connection) DriverManager.getConnection(dbCredential.getDbURL(),
						dbCredential.getDbUserName(),dbCredential.getDbPassword());
				
				if(dbConnection!=null) 
				{
					System.out.println("connect Succeffully");
				}
				else System.out.println("connect failed!");
			 } 
			 catch (SQLException e) 
			 {
				 e.printStackTrace();
			 }
		}
		
		try {
			createTable(Const.TABLE_USER, 
					Const.CREATE_TABLE_USER, dbConnection);
			createTable(Const.TABLE_PASSWORD, 
					Const.CREATE_TABLE_PASSWORD, dbConnection);
			createTable(Const.TABLE_ROLE, 
					Const.CREATE_TABLE_ROLE, dbConnection);
			createTable(Const.TABLE_USER_ROLE, 
					Const.CREATE_TABLE_USER_ROLE, dbConnection);
			createTable(Const.TABLE_PRODUCT, 
					Const.CREATE_TABLE_PRODUCT, dbConnection);
			createTable(Const.TABLE_STOCK, 
					Const.CREATE_TABLE_STOCK, dbConnection);
			createTable(Const.TABLE_SALE, 
					Const.CREATE_TABLE_SALE, dbConnection);
			createTable(Const.TABLE_SALE_ITEM, 
					Const.CREATE_TABLE_SALE_ITEM, dbConnection);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Create a getInstance method
	public static DBConnection getInstance() throws ClassNotFoundException 
	{
		if(instance == null) 
		{
			instance = new DBConnection();
		}
		return instance;
	}

	//getter method :Access db connection
	public Connection getDbConnection() 
	{
		return dbConnection;
	}
		
		
	public void createTable(String tableName, 
			String tableQuery,
			Connection connection) throws SQLException 
	{
		Statement sqlStatement;
		//Grab the database meta data
		DatabaseMetaData md = connection.getMetaData();
		//Grab if the table exists in the database
		ResultSet result = md.getTables(null, null, tableName, null);
		//if I have a next value (the table exists, otherwise it does not)
		if(result.next()) 
		{
			System.out.println( tableName + " Table already exists");
		}
		else 
		{
			sqlStatement = connection.createStatement();
			sqlStatement.execute(tableQuery);
			System.out.println("The " + tableName + " table has been inserted");
		}
	}
	
//	/**
//	 * -Description: Search Database and return the search result.
//	 * @param sql
//	 * @return ResultSet
//	 */
//	public ResultSet searchReult(String sql) {
//		 ResultSet resultSet=null;	
//		try {
//			  statement=(Statement) dbConnection.createStatement();
//			  resultSet= statement.executeQuery(sql);
//
//			  
//		    } catch (SQLException e) 
//			  {e.printStackTrace();
//		       System.out.println("Empty search");
//			  }
//		return resultSet;
//			
//	}
//	
//	
//	/**
//	 * @description Executing: update,delete,insert according parameter sql statement
//	 * @param String updateSql
//	 * @return boolean value(true/false)
//	 */
//	public Boolean UpdateRecords(String updateSql) {
//		 int rowsOfUpdate=0;
//		try {
//			statement=(Statement) dbConnection.createStatement();
//		rowsOfUpdate=statement.executeUpdate(updateSql);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//0:means no records was updated, other number is the count of affected records
//		if(rowsOfUpdate==0) {return false;}
//		else {return true;}
//		
//	}
	
}

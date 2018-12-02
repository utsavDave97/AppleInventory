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
	
	/**
	 * Description: Using ReadCredential class to read database credential file, 
	 *             then Initialize database connection
	 * @return void
	 * @throws ClassNotFoundException
	 */
	private DBConnection() 
	{
		
		if(dbConnection == null) {
			//Try and make a connection
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = 
				DriverManager//192.168.64.2
				.getConnection("jdbc:mysql://192.168.64.2/"+
				 Const_Credential.DB_NAME + "?useSSL=false",
				 Const_Credential.DB_USER, Const_Credential.DB_PASS);
				System.out.println("Successfully Created Connection");
			}
			catch(Exception e) {
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
	public static DBConnection getInstance()
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
	
}

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
	//create a DBconnection instance and set its value to null
	private static DBConnection instance = null;
	//create a Connection instance and set its value to null
	private static Connection dbConnection=null;

	/**
	 * Description: Using ReadCredential class to read database credential file, 
	 *             then Initialize database connection
	 * @return void
	 * @throws ClassNotFoundException
	 */
	private DBConnection() 
	{
		//check to see if dbconnection is null(no current connection to DB)
		if(dbConnection == null) {
			//Try and make a connection
			try {
				ReadCredential credential=new ReadCredential();
				//set the className for the mysql connector
				Class.forName("com.mysql.jdbc.Driver");
				//initiate the DBconnection and create a connection to the database
				dbConnection = 
						DriverManager//macbook xamp:  192.168.64.2 ::::::::::: jonathansPC: 127.0.0.1//phpmyadmin.scweb.ca
						.getConnection("jdbc:mysql://"+credential.getServerAddress()+"/"+
								credential.getDbName() + "?useSSL=false",
								credential.getDbUserName(), credential.getDbPassword());
				System.out.println("Successfully Created Connection");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		try {
			//if there is a connection create the tables using the queries inside the Const file
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
		//check to see if the instance of instance is null
		if(instance == null) 
		{
			//if it is null then create a new dbconnection
			instance = new DBConnection();
		}
		//return the connection
		return instance;
	}

	//getter method :Access db connection
	public Connection getDbConnection() 
	{
		//return the Database connection
		return dbConnection;
	}

	//create the method for creating the tables
	public void createTable(String tableName, 
			String tableQuery,
			Connection connection) throws SQLException 
	{
		//set an instance of the statement class
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
			//create the table's
			sqlStatement = connection.createStatement();
			sqlStatement.execute(tableQuery);
			System.out.println("The " + tableName + " table has been inserted");
		}
	}

}

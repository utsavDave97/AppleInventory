package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - Description:
 * @author wjqcau
 *
 */
public class DBConnection {
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
			try {
				 //Load class
				 Class.forName(dbCredential.getDbDriver());
				 //Initializing dbconnection
				dbConnection= (Connection) DriverManager.getConnection(dbCredential.getDbURL()+"?useSSL=false",
						dbCredential.getDbUserName(),dbCredential.getDbPassword());
				if(dbConnection!=null) {System.out.println("connect Succeffully");}
				else System.out.println("connect failed!");
			   } 
			 catch (SQLException e) 
			 {
				 e.printStackTrace();
			 }
		}
	}
	
	//Create a getInstance method
	public static DBConnection getInstance() throws ClassNotFoundException {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	//getter method :Access db connection
		public Connection getDbConnection() {
			return dbConnection;
		}
	
	/**
	 * -Description: Search Database and return the search result.
	 * @param sql
	 * @return ResultSet
	 */
	public ResultSet searchReult(String sql) {
		 ResultSet resultSet=null;	
		try {
			  statement=(Statement) dbConnection.createStatement();
			  resultSet= statement.executeQuery(sql);

			  
		    } catch (SQLException e) 
			  {e.printStackTrace();
		       System.out.println("Empty search");
			  }
		return resultSet;
			
	}
	
	
	/**
	 * @description Executing: update,delete,insert according parameter sql statement
	 * @param String updateSql
	 * @return boolean value(true/false)
	 */
	public Boolean UpdateRecords(String updateSql) {
		 int rowsOfUpdate=0;
		try {
			statement=(Statement) dbConnection.createStatement();
		rowsOfUpdate=statement.executeUpdate(updateSql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//0:means no records was updated, other number is the count of affected records
		if(rowsOfUpdate==0) {return false;}
		else {return true;}
		
	}
	
	
	
	

}

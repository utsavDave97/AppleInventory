package Dababase;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author Jianqin Wang
 * @description: This class mainly read database credential.
 *   It has dbDriver,dbUrl,dbUserName,dbPassword properties which are initialized
 *   in constructor. Other class (dabaseDAO) can get these information for database 
 *   connection. 
 */

public class ReadCredential {
	//Define properties to get database credentials
	private String dbDriver;
	  private String dbURL;
	  private String dbUserName;
	  private String dbPassword;
	  /**
	   * Constructor:Initializing dbDriver,dbURL,dbURL,dbUserName,dbPassword
	   */
	  public ReadCredential() {
	  Properties dbcredential =new Properties();
	  InputStream inputStream=null;
	   
	  try {
		  //Initialize inputstream
		 inputStream=ReadCredential.class.getClassLoader().getResourceAsStream("dbcredential.properties");
		 //Load inputstream
		 dbcredential.load(inputStream);
		 //Grab properties from file
		 this.dbDriver=dbcredential.getProperty("DB_DRIVER");
		 this.dbURL=dbcredential.getProperty("DB_URL");
		 this.dbUserName=dbcredential.getProperty("USERNAME");
		 this.dbPassword=dbcredential.getProperty("PASSWORD");
	     } catch (IOException e) {e.printStackTrace(); }
		
	  }

	/**
	 * @return the dbDriver
	 */
	public String getDbDriver() {
		return String.format(dbDriver);
	}
	/**
	 * @return the dbURL
	 */
	public String getDbURL() {
		return String.format(dbURL);
	}
	/**
	 * @return the dbUserName
	 */
	public String getDbUserName() {
		return String.format(dbUserName);
	}
	/**
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return (dbPassword);
	}

}

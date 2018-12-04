package Database;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * @author Jianqin Wang
 *
 */
public class ReadCredential {
  private String dbDriver;
  private String dbName;
  private String dbUserName;
  private String dbPassword;
  private String serverAddress;
  File f;
private String wantInitialize;
  
  /**
   * Constructor:Decide whether file exist, if no , create a empty template
   */
  public ReadCredential() {
	  Properties prop = new Properties();
	try {
	  f=new File("dbcredential.properties");}catch (Exception e) {
		e.printStackTrace();
	}
	if(!f.exists()) {
		
		 try {
		        prop.setProperty("USERNAME", "null");
		        prop.setProperty("PASSWORD","null");
		        prop.setProperty("DB_NAME", "null");
		        prop.setProperty("SERVERADDRESS", "null");
		        prop.setProperty("wantInitialize", "yes");
		        OutputStream out = new FileOutputStream(f);
		        prop.store(out, "This is an optional header comment string");
		    }
		    catch (Exception e ) {
		        e.printStackTrace();
		    }
		
	}  
	
  }
  public void WriteCredential(String userName,String passWord,String dbName,String serverAddress,String wantInitialize) {
	  try {
	        Properties props = new Properties();
	        props.setProperty("USERNAME", userName);
	        props.setProperty("PASSWORD",passWord);
	        props.setProperty("DB_NAME", dbName);
	        props.setProperty("SERVERADDRESS", serverAddress);
	        props.setProperty("wantInitialize", wantInitialize);

	       
	        
	        OutputStream out = new FileOutputStream(f);
	        props.store(out, "This is an optional header comment string");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	  
	  
  }
  //read and initialize the object'properties
  public void readCredentialValue() {
	  Properties prop = new Properties();
	  InputStream inputStream=null;
	  
	  try {
		  //Initialize inputstream
		 inputStream=new FileInputStream(f);
		 prop.load(inputStream);
		 this.dbDriver=prop.getProperty("DB_DRIVER");
		 this.dbName=prop.getProperty("DB_NAME");
		 this.dbUserName=prop.getProperty("USERNAME");
		 this.dbPassword=prop.getProperty("PASSWORD");
		 this.wantInitialize=prop.getProperty("wantInitialize");
		 this.serverAddress=prop.getProperty("SERVERADDRESS");
	     } catch (IOException e) {e.printStackTrace(); }
	  
	  
  }
  
  
  
  
public String getDbDriver() {
	return dbDriver;
}
public void setDbDriver(String dbDriver) {
	this.dbDriver = dbDriver;
}
public String getDbName() {
	return dbName;
}
public void setDbName(String dbName) {
	this.dbName = dbName;
}
public String getDbUserName() {
	return dbUserName;
}
public void setDbUserName(String dbUserName) {
	this.dbUserName = dbUserName;
}
public String getDbPassword() {
	return dbPassword;
}
public void setDbPassword(String dbPassword) {
	this.dbPassword = dbPassword;
}
public String getWantInitialize() {
	return wantInitialize;
}
public void setWantInitialize(String wantInitialize) {
	this.wantInitialize = wantInitialize;
}
  
public String getServerAddress() {
	return serverAddress;
}
public void setServerAddress(String serverAddress) {
	this.serverAddress = serverAddress;
}

}

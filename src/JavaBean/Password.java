package JavaBean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

import Database.Const;
import Database.DBConnection;

/**
 * @description this class is responding to database table Password
 * @author wjqcau
 *
 */
public class Password {
	//create an email_id so we can reference this for each user
	private int email_id;
	//create a password so we can reference this for each user
	private String password;
	
    public Password() {}

    //create a construct for just taking a passoword
    
    public Password(String password) {
    		super();
    		//set this password to the password given
    		this.password = password;
    }
    //create a second construct for both email, and password
	public Password(int email_id, String password) {
		super();
		//set this email_id to the email_id given
		this.email_id = email_id;
		//set this password to the password given
		this.password = password;
	}
    //getter and setter's for each method
	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}

	public String getUser_password() {
		return password;
	}

	public void setUser_password(String password) {
		this.password = password;
	}
	//create the way we will hash the password to enter it into the database
	public String hashPassword(String password,String salt) {
		String hashedPassword = null;
		
		password += salt;
		
		/**
		 * this function bellow will generate a 12 character String and will append it to the password at the end
		 * 
		 */
		
		try {
			//follows the same way i did this in php but with different methods of doing so
			//1.)create the messagedigest so we can set the instance of sha-256 the strongest and most
			//secure hashing method of 2018.
			MessageDigest messagedigest = MessageDigest.getInstance("Sha-256");
			//here we will use sha-256 to convert the password to a hashed long number
			//we will then grab the the bytes from our specific password
			messagedigest.update(password.getBytes());
			//here we take the hashed string and convert it to bytes
			byte[] hashedByte = messagedigest.digest();
			//here we use the datatypeconverter and cast the hexedpassed to the string we created locally
			hashedPassword = DatatypeConverter.printHexBinary(hashedByte);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//return the hashed password
		return hashedPassword;
	}
	
	public BigInteger saltGen() {
		String salt = null;
		SecureRandom rand = new SecureRandom();
//		byte[] genSalt = new byte[64];
//		rand.nextBytes(genSalt);
		BigInteger bigI = new BigInteger(32,rand);		

		
		return bigI;
	}

	public String grabSaltFromEmail(int email_id) {

		String USER_LOGIN_SCRIPT = "SELECT "+ Const.PASSWORD_COLUMN_SALT +" FROM "
				+ Const.TABLE_PASSWORD +" WHERE " + Const.USER_COLUMN_EMAIL_ID +" = "+ "'"+ email_id+"' LIMIT 1";
	
		
		String salt = null;
		try {
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			if(pass != null) {
				if(pass.next()) {
					salt = pass.getString("salt");
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return salt;
	}
	
}

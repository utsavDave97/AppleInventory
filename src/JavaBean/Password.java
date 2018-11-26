package JavaBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import Database.Const;

/**
 * @description this class is responding to database table:password_table
 * @author wjqcau
 *
 */
public class Password {
	private int email_id;
	private String password;
	
    public Password() {}

    //create a method for just taking a passoword
    
    public Password(String password) {
    		super();
    		this.password = password;
    }
    
	public Password(int email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}
    //getter and setter


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
	public String hashPassword(String password) {
		String hashedPassword = null;
		
		//create function to make a 6 character string
		
		
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
	

	public Boolean validatePassword(int email_id, String passHash) {
		
		String USER_LOGIN_SCRIPT = "SELECT "+ Const.PASSWORD_COLUMN_PASS +" FROM "
				+ Const.PASSWORD_COLUMN_PASS +" WHERE " + Const.PASSWORD_COLUMN_EMAIL_ID +" = "+ "'"+ email_id+"'"+"LIMIT 1 ";
		
		//create query to see if passedhash equals this newly pulled passed hash
		
		return false;
	}

}

package JavaBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Const;
import Database.DBConnection;

public class User {
	//Declare properties which are exactly the same with user_table fields
	private int email_id;
	private String email;
	private String fname;
	private String lname;

	//Constructor:no parameter
	public User() {}

	//Constructor:all parameters
	public User(int email_id,String email, String fname, String lname) {
		super();
		this.email_id = email_id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}

	public User(String email, String fname, String lname) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}
	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}

	//Getter and setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return fname;
	}

	public void setFirstname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lname;
	}

	public void setLastname(String lname) {
		this.lname = lname;
	} 

	//create a custom method to check the entire database for an email 
	public boolean searchAllEmails(String givenEmail) {

		String USER_LOGIN_SCRIPT = "SELECT "+ Const.USER_COLUMN_EMAIL +" FROM "
				+ Const.TABLE_USER +" WHERE " + Const.USER_COLUMN_EMAIL +" = "+ "'"+ givenEmail+"'";
		

		try {
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			if(pass != null) {
				if(pass.next()) {
					System.out.println(pass.getString("email"));
					return true;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}


		return false;
	}

}


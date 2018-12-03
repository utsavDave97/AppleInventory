package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import DAO.PasswordDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Password;

public class PasswordTable implements PasswordDAO{

	@Override
	public ArrayList<Password> getAllPasswords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getPassword(String passHash, int email_id) {

		//create the SQL query
		String USER_LOGIN_SCRIPT = "SELECT "+ Const.PASSWORD_COLUMN_PASS +" FROM "
				+ Const.PASSWORD_COLUMN_PASS +" WHERE " + Const.PASSWORD_COLUMN_EMAIL_ID +" = "+ "'"+ email_id+"'"+"LIMIT 1 ";

		//create an emtpy string to store the DB hash thats connected to the database
		String dbHash = null;

		try {
			//create a instance of the DB connection
			DBConnection db = DBConnection.getInstance();
			//prepare a statement for our DB
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			//execute the statement
			ResultSet pass = preparedStatement.executeQuery();

			//check to see if pass is null
			if(pass != null) {
				if(pass.next()) {
					//set dbhash to the password column that was retreived from our DB
					dbHash = pass.getString("password");
					System.out.println("Password Linked to email: " +dbHash);
					System.out.println("Password given in login: "+passHash);

					if(passHash.equals(dbHash)) {
						return true;
					}


				}

			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void updatePassword(Password password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePassword(Password password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPassword(Password password, String salt) {
		//create a instance of the DB connection
		String query = "INSERT INTO " + Const.TABLE_PASSWORD + "(" + Const.PASSWORD_COLUMN_PASS + "," +
				Const.PASSWORD_COLUMN_SALT + ") VALUES ('"+
				password.getUser_password() + "','" + salt +"');";

		try {
			//create a instance of the DB connection
			DBConnection db = DBConnection.getInstance();
			//prepare a statement for our DB and execute it
			db.getDbConnection().createStatement().execute(query);

		}catch(SQLException  e) {
			e.printStackTrace();
		}

	}

}

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
	public Boolean getPassword(String passHash) {


		String USER_LOGIN_SCRIPT = "SELECT "+ Const.PASSWORD_COLUMN_PASS +" FROM "
				+ Const.PASSWORD_COLUMN_PASS +" WHERE " + Const.PASSWORD_COLUMN_PASS +" = "+ "'"+ passHash+"'"+"LIMIT 1 ";
		boolean matchedpass = false;
		String matchedPassString = null;

		try {
			//System.out.println(passHash);
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			System.out.println(pass != null);
			if(pass != null) {
				if(pass.next()) {
					
					System.out.println(passHash);
					String test = pass.getString("password");
					System.out.println(test);

					return true;
				}
				
			}
			
//			System.out.println("PassWord match!");
//			System.out.println("Logged in!");
			//System.out.println(db.getDbConnection().createStatement().execute(USER_LOGIN_SCRIPT));
			
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
	public void createPassword(Password password) {

		String query = "INSERT INTO " + Const.TABLE_PASSWORD + "(" + Const.PASSWORD_COLUMN_PASS +") VALUES ('"+
				password.getUser_password()+"')";

		try {
			DBConnection db = DBConnection.getInstance();
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted record!");
		}catch(SQLException  e) {
			e.printStackTrace();
		}

	}

}

package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.UserDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.User;

public class UserTable implements UserDAO{

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUser(String email) {
		
		String USER_LOGIN_SCRIPT = "SELECT "+ Const.USER_COLUMN_EMAIL_ID +" FROM "
				+ Const.TABLE_USER +" WHERE " + Const.USER_COLUMN_EMAIL +" = "+ "'"+ email+"'"+"LIMIT 1 ";
		
		
		String matchedEmailString = null;

		
		int email_id = 0;
		try {
			//System.out.println(passHash);
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			ResultSet pass = preparedStatement.executeQuery();
			
			System.out.println(pass != null);
			if(pass != null) {
				if(pass.next()) {
					
					email_id = pass.getInt("email_id");
					
					return email_id;
				}
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return email_id = 0;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		String query = "INSERT INTO " + Const.TABLE_USER + "(" + Const.USER_COLUMN_EMAIL+", "
				+ Const.USER_COLUMN_FNAME+", "+Const.USER_COLUMN_LNAME + ") VALUES ('"+
				user.getEmail()+"','"+user.getFirstname()+"','"+user.getLastname()+"')";
		try {
			DBConnection db = DBConnection.getInstance();
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted record!");
		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}

}

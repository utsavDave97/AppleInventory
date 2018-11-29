package Tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.UserDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.Product;
import JavaBean.User;
import Screens.TableViewItems.ScreenUser;

public class UserTable implements UserDAO{

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users;
		users = new ArrayList<User>();
		String query = "SELECT * FROM " + Const.TABLE_USER;
		try {
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			ResultSet pass = preparedStatement.executeQuery();
			
			if(pass != null) {
				if(pass.next()) {
					users.add(new User(pass.getInt(Const.USER_COLUMN_EMAIL_ID),pass.getString(Const.USER_COLUMN_EMAIL), pass.getString(Const.USER_COLUMN_FNAME), pass.getString(Const.USER_COLUMN_LNAME)));
				}
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
			
		
		return users;
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
	
public User getUser(int email_id) {		
		String query = "SELECT *"+" FROM "
				+ Const.TABLE_USER +" WHERE " + Const.USER_COLUMN_EMAIL_ID +" = "+email_id+" LIMIT 1 ";
			User user = null;
 		try {
			
			DBConnection db = DBConnection.getInstance();
			Statement uerStatement = db.getDbConnection().createStatement();
			ResultSet userRS =uerStatement.executeQuery(query);
			userRS.next();
			user=new User(userRS.getInt(Const.USER_COLUMN_EMAIL_ID),userRS.getString(Const.USER_COLUMN_EMAIL),
					userRS.getString(Const.USER_COLUMN_FNAME),userRS.getString(Const.USER_COLUMN_LNAME));
		}catch(SQLException  e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

	@Override
	public void updateUser(User user) {

		String query = null;
		
		if(user.getEmail() != null && user.getFirstname() != null && user.getLastname() != null) {
			query = "UPDATE " + Const.TABLE_USER + " SET " +
			        Const.USER_COLUMN_EMAIL + "='" + user.getEmail() +  "' ," +
					Const.USER_COLUMN_FNAME + "='" + user.getFirstname() + "' ,"+
			        Const.USER_COLUMN_LNAME + "='" + user.getLastname() + "'" +
			         " WHERE " + Const.USER_COLUMN_EMAIL_ID + " = " + user.getEmail_id()+";";	
		}
		
		
		try {
			//System.out.println(passHash);
			System.out.println(query);
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			preparedStatement.execute();


		}catch(SQLException  e) {
			e.printStackTrace();
		}
		
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
	
	public ArrayList<ScreenUser> getAllUsersForTableView() {
		ArrayList<ScreenUser> users;
		users = new ArrayList<ScreenUser>();
		String query = "SELECT * FROM " + Const.TABLE_USER;
		try {
			DBConnection db = DBConnection.getInstance();
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			ResultSet pass = preparedStatement.executeQuery();
			
			
			
			if(pass != null) {
				while(pass.next()) {
					System.out.println("test");
					users.add(new ScreenUser(pass.getInt(Const.USER_COLUMN_EMAIL_ID),pass.getString(Const.USER_COLUMN_EMAIL), pass.getString(Const.USER_COLUMN_FNAME), pass.getString(Const.USER_COLUMN_LNAME)));
				}
				
			}

		}catch(SQLException  e) {
			e.printStackTrace();
		}
			
		
		return users;
	}

}

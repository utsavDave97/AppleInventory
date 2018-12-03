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
		//create a new arraylist for the user class
		ArrayList<User> users;
		users = new ArrayList<User>();
		//create a query
		String query = "SELECT * FROM " + Const.TABLE_USER;
		try {
			//get the instance of DB
			DBConnection db = DBConnection.getInstance();
			//prepare the query
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			//execute
			ResultSet pass = preparedStatement.executeQuery();

			if(pass != null) {
				if(pass.next()) {
					//add the new user to the class
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
		
		//create the query
		String USER_LOGIN_SCRIPT = "SELECT "+ Const.USER_COLUMN_EMAIL_ID +" FROM "
				+ Const.TABLE_USER +" WHERE " + Const.USER_COLUMN_EMAIL +" = "+ "'"+ email+"'"+"LIMIT 1 ";


		String matchedEmailString = null;


		int email_id = 0;
		try {
			//get the instance
			DBConnection db = DBConnection.getInstance();
			//prepare the statement
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(USER_LOGIN_SCRIPT);
			//execute the query
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
		//create the query
		String query = "SELECT *"+" FROM "
				+ Const.TABLE_USER +" WHERE " + Const.USER_COLUMN_EMAIL_ID +" = "+email_id+" LIMIT 1 ";
		//create a new user object
		User user = null;
		try {
			//grab the instance of the db
			DBConnection db = DBConnection.getInstance();
			//create a new statement
			Statement uerStatement = db.getDbConnection().createStatement();
			//execute the query
			ResultSet userRS =uerStatement.executeQuery(query);
			userRS.next();
			//add the user to the user list
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

		//create a query 
		if(user.getEmail() != null && user.getFirstname() != null && user.getLastname() != null) {
			query = "UPDATE " + Const.TABLE_USER + " SET " +
					Const.USER_COLUMN_EMAIL + "='" + user.getEmail() +  "' ," +
					Const.USER_COLUMN_FNAME + "='" + user.getFirstname() + "' ,"+
					Const.USER_COLUMN_LNAME + "='" + user.getLastname() + "'" +
					" WHERE " + Const.USER_COLUMN_EMAIL_ID + " = " + user.getEmail_id()+";";	
		}


		try {
			//System.out.println(passHash);
			//grab the instance with the dbclass
			DBConnection db = DBConnection.getInstance();
			//prepare the statement
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			//execute the statement
			preparedStatement.execute();


		}catch(SQLException  e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int position) {
		//create a query
		String query = "DELETE FROM " +"`"+Const.TABLE_USER+"`"+" WHERE "+Const.USER_COLUMN_EMAIL_ID+" = "+position+";";

		try {
			System.out.println(query);
			//grab the instance of the dbconnection
			DBConnection db = DBConnection.getInstance();
			//create the prepared statement for the query
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			//execute the query
			preparedStatement.execute();

		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createUser(User user) {
		//create a query
		String query = "INSERT INTO " + Const.TABLE_USER + "(" + Const.USER_COLUMN_EMAIL+", "
				+ Const.USER_COLUMN_FNAME+", "+Const.USER_COLUMN_LNAME + ") VALUES ('"+
				user.getEmail()+"','"+user.getFirstname()+"','"+user.getLastname()+"')";
		try {
			//grab the instance of the DB class
			DBConnection db = DBConnection.getInstance();
			//execute the query
			db.getDbConnection().createStatement().execute(query);
			//System.out.println("Inserted record!");
		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ScreenUser> getAllUsersForTableView() {
		//create an arraylist for all users
		ArrayList<ScreenUser> users;
		users = new ArrayList<ScreenUser>();
		//create a query
		String query = "SELECT * FROM " + Const.TABLE_USER;
		try {
			//get the instance from the dbclass
			DBConnection db = DBConnection.getInstance();
			//prepare the statement
			PreparedStatement preparedStatement = db.getDbConnection().prepareStatement(query);
			//execute the statement
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

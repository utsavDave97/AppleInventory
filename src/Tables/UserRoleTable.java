package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.UserRoleDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.UserRole;
import Screens.updateStockScreen;

public class UserRoleTable implements UserRoleDAO{

	@Override
	public ArrayList<UserRole> getAllUserRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getUserRole(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserRole(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createUserRole(UserRole userRole) {
		//create the query
		String query = "INSERT INTO " + Const.TABLE_USER_ROLE + "(" + Const.USER_ROLE_COLUMN_ID +") VALUES ('"+userRole.getRole_Id()+"')";

		try {
			//get the instance of DB
			DBConnection db = DBConnection.getInstance();
			//prepare the query & execute
			db.getDbConnection().createStatement().execute(query);
			System.out.println("Inserted record!");
		}catch(SQLException  e) {
			e.printStackTrace();
		}		
	}
public void updateRole(int roleId,int emailId) {
	String query = "UPDATE " + Const.TABLE_USER_ROLE + " SET " + Const.USER_ROLE_COLUMN_ID +"="+roleId+
			" WHERE "+Const.USER_ROLE_COLUMN_EMAIL_ID+"="+emailId;
	
	try {
		DBConnection db = DBConnection.getInstance();
		db.getDbConnection().createStatement().executeUpdate(query);
		System.out.println("Inserted record!");
	}catch(SQLException  e) {
		e.printStackTrace();}
	}		
	

	public int getRoleId(int email_id) {
		int roleId=0;
		DBConnection db = DBConnection.getInstance();
		String query="SELECT "+Const.USER_ROLE_COLUMN_ID+" From "+Const.TABLE_USER_ROLE+
				" WHERE "+Const.USER_ROLE_COLUMN_EMAIL_ID+"="+email_id;
		try {

			Statement statement=db.getDbConnection().createStatement();
			ResultSet data=statement.executeQuery(query);
			if(data.next()) {
				roleId=data.getInt(Const.USER_ROLE_COLUMN_ID);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return roleId;

	}

}

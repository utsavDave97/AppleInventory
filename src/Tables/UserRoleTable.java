package Tables;

import java.sql.SQLException;
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
		String query = "INSERT INTO " + Const.TABLE_USER_ROLE + "(" + Const.USER_ROLE_COLUMN_ID +") VALUES ('"+userRole.getRole_Id()+"')";
		
		try {
			DBConnection db = DBConnection.getInstance();
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
		e.printStackTrace();
	}		
	
	
	}

}

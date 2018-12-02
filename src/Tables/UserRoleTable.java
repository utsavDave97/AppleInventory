package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.UserRoleDAO;
import Database.Const;
import Database.DBConnection;
import JavaBean.UserRole;

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

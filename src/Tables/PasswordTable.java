package Tables;

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
	public Password getPassword(int id) {
		// TODO Auto-generated method stub
		return null;
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

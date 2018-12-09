package DAO;

import java.util.ArrayList;

import JavaBean.Password;

public interface PasswordDAO 
{

	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our Password class
	 */
	
	public ArrayList<Password> getAllPasswords();
	public Boolean getPassword(String passHash, int email_id);
	public void updatePassword(Password password);
	public void deletePassword(Password password);
	void createPassword(Password password, String salt);
}

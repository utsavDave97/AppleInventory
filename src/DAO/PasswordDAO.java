package DAO;

import java.util.ArrayList;

import JavaBean.Password;

public interface PasswordDAO 
{

	public ArrayList<Password> getAllPasswords();
	public Boolean getPassword(String passHash);
	public void updatePassword(Password password);
	public void deletePassword(Password password);
	public void createPassword(Password password);
}

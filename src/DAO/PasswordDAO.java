package DAO;

import java.util.ArrayList;

import JavaBean.Password;

public interface PasswordDAO 
{

	public ArrayList<Password> getAllPasswords();
	public Password getPassword(int id);
	public void updatePassword(Password password);
	public void deletePassword(Password password);
	public void createPassword(Password password);
}

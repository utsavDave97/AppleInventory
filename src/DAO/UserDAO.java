package DAO;

import java.util.ArrayList;

import JavaBean.User;


public interface UserDAO 
{
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our User class
	 */
	
	public ArrayList<User> getAllUsers();
	public int getUser(String email);
	public void updateUser(User user);
	public void deleteUser(int position);
	public void createUser(User user);
}

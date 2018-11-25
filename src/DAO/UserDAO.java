package DAO;

import java.util.ArrayList;

import JavaBean.User;


public interface UserDAO 
{
	public ArrayList<User> getAllUsers();
	public Boolean getUser(String email);
	public void updateUser(User user);
	public void deleteUser(User user);
	public void createUser(User user);
}

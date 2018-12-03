package DAO;

import java.util.ArrayList;

import JavaBean.UserRole;

public interface UserRoleDAO 
{
	
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our User Role class
	 */
	
	public ArrayList<UserRole> getAllUserRoles();
	public UserRole getUserRole(int id);
	public void updateUserRole(UserRole userRole);
	public void deleteUserRole(UserRole userRole);
	public void createUserRole(UserRole userRole);
}

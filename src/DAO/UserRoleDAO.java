package DAO;

import java.util.ArrayList;

import JavaBean.UserRole;

public interface UserRoleDAO 
{
	public ArrayList<UserRole> getAllUserRoles();
	public UserRole getUserRole(int id);
	public void updateUserRole(UserRole userRole);
	public void deleteUserRole(UserRole userRole);
	public void createUserRole(UserRole userRole);
}

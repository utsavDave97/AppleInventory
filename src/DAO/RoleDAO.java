package DAO;

import java.util.ArrayList;

import JavaBean.Role;

public interface RoleDAO 
{
	/**
	 * 
	 * @description this class is to specify a list of basic functions to be implemented inside our Role class
	 */
	
	public ArrayList<Role> getAllRoles();
	public Role getRole(int id);
	public void updateRole(Role role);
	public void deleteRole(Role role);
	public void createRole(Role role);
}

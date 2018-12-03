package JavaBean;
/**
 * @description this class is in responding to database table:role_table
 * @author wjqcau
 */
public class Role {
//create an role_id so we can reference this for each user
 private int role_id;
//create an role_name so we can reference this for each user
 private String role_name;
 //Constructor without parameter
 public Role() {}
 //Constructor with all parameters
public Role(char role_id, String role_name) {
	super();
	this.role_id = role_id;
	this.role_name = role_name;
}
 //getter and setters
public int getRole_Id() {
	return role_id;
}
public void setRole_Id(int role_id) {
	this.role_id = role_id;
}
public String getRole_name() {
	return role_name;
}
public void setRole_name(String role_name) {
	this.role_name = role_name;
}
 
 
}

package JavaBean;
/**
 * @description this class is in responding to database table:role_table
 * @author wjqcau
 */
public class Role {
 private char role_Id;
 private String role_name;
 //Constructor without parameter
 public Role() {}
 //Constructor with all parameters
public Role(char role_Id, String role_name) {
	super();
	this.role_Id = role_Id;
	this.role_name = role_name;
}
 //getter and setters
public char getRole_Id() {
	return role_Id;
}
public void setRole_Id(char role_Id) {
	this.role_Id = role_Id;
}
public String getRole_name() {
	return role_name;
}
public void setRole_name(String role_name) {
	this.role_name = role_name;
}
 
 
}

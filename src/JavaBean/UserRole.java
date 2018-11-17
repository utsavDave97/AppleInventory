package JavaBean;
/**
 * @description this class is in responding to database table:user_role
 * @author wjqcau
 */
public class UserRole {
 private String email;
 private int role_id;
 //Constructor without parameter
 public UserRole() {}
 //constructor with one paramater
 public UserRole(int role_id) {
	 super();
	 this.role_id = role_id;
 }
 //Constructor with all parameters
public UserRole(String email, char role_id) {
	super();
	this.email = email;
	this.role_id = role_id;
}
 //getter and setters
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getRole_Id() {
	return role_id;
}
public void setRole_Id(int role_id) {
	this.role_id = role_id;
}

}

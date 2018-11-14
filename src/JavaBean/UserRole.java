package JavaBean;
/**
 * @description this class is in responding to database table:user_role
 * @author wjqcau
 */
public class UserRole {
 private String email;
 private char role_id;
 //Constructor without parameter
 public UserRole() {}
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
public char getRole_Id() {
	return role_id;
}
public void setRole_Id(char role_id) {
	this.role_id = role_id;
}

}

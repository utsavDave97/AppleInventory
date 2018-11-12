package JavaBean;
/**
 * @description this class is in responding to database table:user_role
 * @author wjqcau
 */
public class userRole {
 private String email;
 private char role_Id;
 //Constructor without parameter
 public userRole() {}
 //Constructor with all parameters
public userRole(String email, char role_Id) {
	super();
	this.email = email;
	this.role_Id = role_Id;
}
 //getter and setters
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public char getRole_Id() {
	return role_Id;
}
public void setRole_Id(char role_Id) {
	this.role_Id = role_Id;
}

}

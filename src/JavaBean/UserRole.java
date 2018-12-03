package JavaBean;
/**
 * @description this class is in responding to database table:user_role
 * @author wjqcau
 */
public class UserRole {
	//create an email_id so we can reference this for each user
	private int email_id;
	//create an role_id so we can reference this for each user
	private int role_id;
	//Constructor without parameter
	public UserRole() {}
	//constructor with one paramater
	public UserRole(int role_id) {
		super();
		this.role_id = role_id;
	}
	//Constructor with all parameters
	public UserRole(int email_id, int role_id) {
		super();
		this.email_id = email_id;
		this.role_id = role_id;
	}


	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public int getRole_Id() {
		return role_id;
	}
	public void setRole_Id(int role_id) {
		this.role_id = role_id;
	}


}

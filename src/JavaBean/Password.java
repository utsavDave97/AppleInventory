package JavaBean;
/**
 * @description this class is responding to database table:password_table
 * @author wjqcau
 *
 */
public class Password {
	private String email;
	private String user_password;
	
    public Password() {}

	public Password(String email, String user_password) {
		super();
		this.email = email;
		this.user_password = user_password;
	}
    //getter and setter

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	

}

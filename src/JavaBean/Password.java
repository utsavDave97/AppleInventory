package JavaBean;
/**
 * @description this class is responding to database table:password_table
 * @author wjqcau
 *
 */
public class Password {
	private String email;
	private String password;
	
    public Password() {}

	public Password(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
    //getter and setter

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_password() {
		return password;
	}

	public void setUser_password(String password) {
		this.password = password;
	}
	

}

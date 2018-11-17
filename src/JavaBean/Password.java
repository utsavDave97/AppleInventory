package JavaBean;
/**
 * @description this class is responding to database table:password_table
 * @author wjqcau
 *
 */
public class Password {
	private int email_id;
	private String password;
	
    public Password() {}

	public Password(int email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}
    //getter and setter


	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}

	public String getUser_password() {
		return password;
	}

	public void setUser_password(String password) {
		this.password = password;
	}
	

}

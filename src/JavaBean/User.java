package JavaBean;

public class User {
  //Declare properties which are exactly the same with user_table fields
  private int email_id;
  private String email;
  private String fname;
  private String lname;
  
  //Constructor:no parameter
  public User() {}
  
  //Constructor:all parameters
public User(int email_id,String email, String fname, String lname) {
	super();
	this.email_id = email_id;
	this.email = email;
	this.fname = fname;
	this.lname = lname;
}

public User(String email, String fname, String lname) {
	super();
	this.email = email;
	this.fname = fname;
	this.lname = lname;
}
public int getEmail_id() {
	return email_id;
}

public void setEmail_id(int email_id) {
	this.email_id = email_id;
}

//Getter and setter
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFirstname() {
	return fname;
}

public void setFirstname(String fname) {
	this.fname = fname;
}

public String getLastname() {
	return lname;
}

public void setLastname(String lname) {
	this.lname = lname;
} 
  
}


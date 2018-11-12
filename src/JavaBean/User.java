package JavaBean;

public class User {
  //Declare properties which are exactly the same with user_table fields
  private String email;
  private String firstname;
  private String lastname;
  
  //Constructor:no parameter
  public User() {}
  
  //Constructor:all parameters
public User(String email, String firstname, String lastname, String telephone, char gender) {
	super();
	this.email = email;
	this.firstname = firstname;
	this.lastname = lastname;
}
//Getter and setter
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
} 
  
}


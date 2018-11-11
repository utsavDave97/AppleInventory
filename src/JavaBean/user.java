package JavaBean;

public class user {
  //Declare properties which are exactly the same with user_table fields
  private String email;
  private String firstname;
  private String lastname;
  private String telephone;
  private char gender;
  //Constructor:no parameter
  public user() {}
  
  //Constructor:all parameters
public user(String email, String firstname, String lastname, String telephone, char gender) {
	super();
	this.email = email;
	this.firstname = firstname;
	this.lastname = lastname;
	this.telephone = telephone;
	this.gender = gender;
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

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public char getGender() {
	return gender;
}

public void setGender(char gender) {
	this.gender = gender;
}
 
  
}


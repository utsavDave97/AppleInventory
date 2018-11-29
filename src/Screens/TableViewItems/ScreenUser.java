package Screens.TableViewItems;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScreenUser {
	private SimpleIntegerProperty email_id;
	private SimpleStringProperty email;
	private SimpleStringProperty fname;
	private SimpleStringProperty lname;
	
	public ScreenUser(String email, String fname,
			String lname) {
		super();
		this.email =new SimpleStringProperty(email);
		this.fname =new SimpleStringProperty( fname);
		this.lname =new SimpleStringProperty(lname);
	}
	
	public ScreenUser(int email_id, String email, String fname,
			String lname) {
		super();
		this.email_id = new SimpleIntegerProperty(email_id);
		this.email =new SimpleStringProperty(email);
		this.fname =new SimpleStringProperty( fname);
		this.lname =new SimpleStringProperty(lname);
	}
	public int getEmail_id() {
		return email_id.get();
	}
	public void setEmail_id(int email_id) {
		this.email_id.set(email_id); 
	}
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public String getFname() {
		return fname.get();
	}
	public void setFname(String fname) {
		this.fname.set(fname);
	}
	public String getLname() {
		return lname.get();
	}
	public void setLname(String lname) {
		this.lname.set(lname);
	}
	 

}

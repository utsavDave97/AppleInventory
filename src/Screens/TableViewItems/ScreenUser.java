package Screens.TableViewItems;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScreenUser 
{
	//create an SimpleIntegerProperty email_id so we can reference this later
	private SimpleIntegerProperty email_id;
	//create an SimpleIntegerProperty email so we can reference this later
	private SimpleStringProperty email;
	//create an SimpleIntegerProperty fname so we can reference this later
	private SimpleStringProperty fname;
	//create an SimpleIntegerProperty lname so we can reference this later
	private SimpleStringProperty lname;
	
	public ScreenUser() 
	{
		super();
	}

	public ScreenUser(String email, String fname,String lname) 
	{
		super();
		this.email =new SimpleStringProperty(email);
		this.fname =new SimpleStringProperty( fname);
		this.lname =new SimpleStringProperty(lname);
	}
	
	public ScreenUser(int email_id, String email, String fname,String lname) 
	{
		super();
		this.email_id = new SimpleIntegerProperty(email_id);
		this.email =new SimpleStringProperty(email);
		this.fname =new SimpleStringProperty( fname);
		this.lname =new SimpleStringProperty(lname);
	}
	
	public int getEmail_id() 
	{
		return email_id.get();
	}
	
	public void setEmail_id(int email_id) 
	{
		this.email_id.set(email_id); 
	}
	
	public String getEmail() 
	{
		return email.get();
	}
	
	public void setEmail(String email) 
	{
		this.email.set(email);
	}
	
	public String getFname() 
	{
		return fname.get();
	}
	
	public void setFname(String fname)
	{
		this.fname.set(fname);
	}
	
	public String getLname() 
	{
		return lname.get();
	}
	
	public void setLname(String lname)
	{
		this.lname.set(lname);
	}
}

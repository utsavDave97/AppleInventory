package Screens.TableViewItems;

import java.util.ArrayList;

import Screens.newTransactionScreen;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

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
	

	ComboBox<Position> comboBox=new ComboBox<>();
	
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
		ArrayList<Position> positions=new ArrayList<>();
		
		positions.add(new Position("clerk"));
		positions.add(new Position("manager"));
		//positions.add(new Position("administrator"));

	
		comboBox.setItems(FXCollections.observableArrayList(positions));
	}
	public ComboBox<Position> getComboBox() {
		return comboBox;
	}


	public void setComboBox(ComboBox<Position> comboBox) {
		this.comboBox = comboBox;
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

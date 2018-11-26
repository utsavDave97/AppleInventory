package Screens.TableViewItems;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public  class ScreenSaleItem {
	 
    private  SimpleIntegerProperty upcNumber;
    private  SimpleStringProperty name;
    private  SimpleStringProperty price;
    private  SimpleStringProperty totPrice;
   // private  TextField quantity;
    private SimpleStringProperty quantity;
    private  CheckBox reviseCheck;
    
    public ScreenSaleItem(int upcNumber, String name, String price,String totPrice,String quantity) {
    	this.quantity=new SimpleStringProperty(quantity);
    	this.reviseCheck=new CheckBox();
    	
    	//reviseCheck.setId("1");
        this.upcNumber = new SimpleIntegerProperty(upcNumber);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
        this.totPrice=new SimpleStringProperty(totPrice);
      
    }

    public String getName() {
        return name.get();
    }

    public void setName(String productName) {
      name.set(productName);
    }

    public int getUpcNumber() {
        return upcNumber.get();
    }

    public void setUpcNumber(int upcNum) {
        upcNumber.set(upcNum);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String productPrice) {
        price.set(productPrice);
    }
    
    
    public void setTotPrice(String totPri) {
    	totPrice.set(totPri);
    }
    public String getTotPrice() {return totPrice.get();}
    
    public void setReviseCheck(CheckBox reviseCheck) {
    	this.reviseCheck=reviseCheck;
    }
    public CheckBox getReviseCheck() {return reviseCheck;}
   
    public String getQuantity() {return quantity.get();}
    public void setQuantity(String quantity) {this.quantity.set(quantity);}	
	
	
	
}
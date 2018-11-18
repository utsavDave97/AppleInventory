package Screens.TableViewItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public  class SaleItem {
	 
    private  SimpleStringProperty upcNumber;
    private  SimpleStringProperty name;
    private  SimpleStringProperty price;
    private  SimpleStringProperty totPrice;
    private  TextField quantity;
    private  CheckBox reviseCheck;
    private  Button delButton;
    public SaleItem(String upcNumber, String name, String price,String totPrice) {
    	this.quantity=new TextField();
    	this.reviseCheck=new CheckBox();
    	this.delButton=new Button("Delete");
    	//reviseCheck.setId("1");
        this.upcNumber = new SimpleStringProperty(upcNumber);
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

    public String getUpcNumber() {
        return upcNumber.get();
    }

    public void setUpcNumber(String upcNum) {
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
    public void setDelButton(Button delButton) {this.delButton=delButton;}
    public Button getDelButton() {return delButton;}
    public TextField getQuantity() {return quantity;}
    public void setQuantity(TextField quantity) {this.quantity=quantity;}	
	
	
	
}
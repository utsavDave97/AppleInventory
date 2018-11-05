package Screens;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
public class currentranTab extends BorderPane{
	public currentranTab() {
		
this.setStyle("-fx-background-color: #DCDCDC;");
		

				//create the content for the Completed transaction
		
		
	    /**********************************************************************
		 *                Table View Content                                  *
		 ***********************************************************************/    
	    TableView<SaleItem> table = new TableView<SaleItem>();
	     final ObservableList<SaleItem> data =
	            FXCollections.observableArrayList(
	            new SaleItem("0001", "Fuji", "2","6"),
	            new SaleItem("0002", "Garla", "3","7"));
	           
	    table.setEditable(true);
	  
	    
        TableColumn upcCol = new TableColumn("UPC Number");
        upcCol.setMinWidth(100);
        upcCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("upcNumber"));
 
        TableColumn nameCol = new TableColumn("Name");
       
        nameCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("name"));
 
        TableColumn priceCol = new TableColumn("Price");
        
        priceCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("price"));
        
       TableColumn totCol = new TableColumn("Total Price");
        
       totCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("totPrice"));
        
 
        TableColumn quantityCol=new TableColumn("Qty");
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("quantity"));
        
        TableColumn reviseCol=new TableColumn("ReviseQty");
        reviseCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("reviseCheck"));
        
        

        TableColumn delCol=new TableColumn("Delete");
        delCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("delButton"));
          
        table.getColumns().addAll(upcCol,nameCol,priceCol,totCol,quantityCol,reviseCol,delCol);
        table.setItems(data);
        table.setMaxWidth(750);
        table.setStyle("-fx-font-size: 14;");
        
        /**********************************************************************
		 *                Bottom tax and totalAmount                           *
		 ***********************************************************************/  
        String textStyle="-fx-font-size:15pt;"
				+ "-fx-font-family: Quicksand;";
        
        //"-fx-fill: #00FFFF;"
	     
        Label taxLable=new Label("Tax:                ");
        taxLable.setStyle("-fx-font-family: Quicksand;"
				  + "-fx-font-size: 15pt;");
       
       
        Text taxText=new Text("0");
        taxText.setStyle(textStyle);
        HBox taxTextBox=new HBox();
        taxTextBox.setStyle("-fx-border-color:green;\n"
        		+ "-fx-border-width:0 0 0 2;\n"
        		+ "-fx-border-style:solid;\n"
        		+ "-fx-padding:0 0 0 10;\n"
        		+ "-fx-background-color:white");
        taxTextBox.getChildren().add(taxText);
        taxTextBox.setMinWidth(460);
        
        HBox taxHbox=new HBox();
        taxHbox.setSpacing(152);
        taxHbox.getChildren().addAll(taxLable,taxTextBox);
       
        
        Label totAmountLable=new Label("Total Amount:");
        totAmountLable.setStyle("-fx-font-family: Quicksand;"
				  + "-fx-font-size: 15pt;");
       
        Text totAmountText=new Text("0");
        
        totAmountText.setStyle("-fx-font-size:15pt;\n" 
        		+ "-fx-font-family: Quicksand;");
        HBox amountTextBox=new HBox();
        amountTextBox.getChildren().add(totAmountText);
        amountTextBox.setStyle("-fx-border-color:green;\n"
        		+ "-fx-border-width:0 0 0 2;\n"
        		+ "-fx-border-style:solid;\n"
        		+ "-fx-padding:0 0 0 10;\n"
        		+ "-fx-background-color:white");
        amountTextBox.setMinWidth(460);
        
        
        
        HBox totAmountHbox=new HBox();
        totAmountHbox.setSpacing(150);
        totAmountHbox.getChildren().addAll(totAmountLable,amountTextBox);
        totAmountHbox.setStyle("-fx-border-color:green;\n"
        		+ "-fx-border-width:2 0 0 0;\n"
        		+ "-fx-border-style:solid;\n"
        		+ "-fx-padding:0 0 0 0");
        
        
        VBox sumDesVbox=new VBox();      
        sumDesVbox.getChildren().addAll(taxHbox,totAmountHbox);
        sumDesVbox.setMaxWidth(750);
        sumDesVbox.setPadding(new Insets(0,0,0,0));
        sumDesVbox.setStyle("-fx-border-color:green;\n"
        		+ "-fx-border-width:2;\n"
        		+ "-fx-border-style:solid;");
        
        
        
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(30, 10, 0, 10));
	   
        vbox.getChildren().addAll(table,sumDesVbox);
	    
	    //create the cancel button
		Button reset = new Button("Cancel");
		//set the styling for the button
		reset.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
		//create the submit button
		Button submit = new Button("Submit");
		//create the register styling
		submit.setStyle("-fx-border-color:B82F33;"
					  + "-fx-font-family: Quicksand;"
					  + "-fx-font-size: 12pt;");
						
		 final HBox hbox = new HBox();
		 hbox.setSpacing(50);
		 hbox.setPadding(new Insets(10, 0, 100, 300));
		    
		 hbox.getChildren().addAll(reset,submit);
	    //Set content to GridPane
		
	    
	   
	    this.setCenter(vbox);
	    this.setBottom(hbox);
	  //create the scene
		
		
		
		//show the stage
	


  }
	 /**
	  * @description this inner class mainly provide data structure for tableview
	  * @author wjqcau
	  *
	  */
    public static class SaleItem {
 
        private  SimpleStringProperty upcNumber;
        private  SimpleStringProperty name;
        private  SimpleStringProperty price;
        private  SimpleStringProperty totPrice;
        private  TextField quantity;
        private  CheckBox reviseCheck;
        private  Button delButton;
        private SaleItem(String upcNumber, String name, String price,String totPrice) {
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

}

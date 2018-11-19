package Screens;

import Screens.TableViewItems.SaleItem;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
        *                Top choose and add sale Item                                  *
        ***********************************************************************/    		
    //Declare a hbox to holding the operations
     HBox addItemBox=new HBox(40); 
     addItemBox.setPadding(new Insets(20,20,20,150));
     addItemBox.setStyle("-fx-border-color:gray;\n"
        		+ "-fx-border-width:0 0 1 0;\n"
        		+ "-fx-border-style:solid;");
     Label nameLabel=new Label("Type:");
     //set the name font
     nameLabel.setStyle("-fx-font-family: Quicksand;"
 				  + "-fx-font-size: 12pt;");
      // Create the ObservableLists for the ComboBox
      ObservableList<String> appleList = FXCollections.<String>observableArrayList("Fuji", 
		"Gala", 
		"Red Delicious", 
		"Granny Smith",
		"Honeycrisp",
		"Golden Delicious",
		"Pink Lady",
		"Opal",
		"Jazz");  
      // Create the ListView for the seasons
      ComboBox appleNames = new ComboBox(appleList);
      //Give the first default selection item
      appleNames.getSelectionModel().selectFirst();
      //Set List Style Font
      appleNames.setStyle(" -fx-font-family: Quicksand;"
				  + "-fx-font-size: 12pt;");
      // Set the Size of the ComoBox
      appleNames.setPrefSize(200, 30);
      //add a button to add more apple items
      Button addItemButton=new Button("Add Item");
      addItemButton.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
      //add deleteItem
      Button deleteItemButton=new Button("Delete Item");
      deleteItemButton.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
      
      
      addItemBox.getChildren().addAll(appleNames,addItemButton,deleteItemButton);
         


	    /**********************************************************************
		 *                Table List Content                                  *
		 ***********************************************************************/    
	    TableView<SaleItem> table = new TableView<SaleItem>();
	     final ObservableList<SaleItem> data =
	            FXCollections.observableArrayList(
	            new SaleItem("0001", "Fuji", "2","6"),
	            new SaleItem("0002", "Garla", "3","7"));
	           
	    table.setEditable(true);
	  
	    TableColumn reviseCol=new TableColumn("Check");
        reviseCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("reviseCheck"));
        
        TableColumn upcCol = new TableColumn("UPC");
        upcCol.setMinWidth(100);
        upcCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("upcNumber"));
        
        TableColumn nameCol = new TableColumn("Name");
       
        nameCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("name"));
        nameCol.setMinWidth(150);
        
        TableColumn priceCol = new TableColumn("Price");
        
        priceCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("price"));
        priceCol.setMinWidth(100);
        
       TableColumn totCol = new TableColumn("Total Price");
        
       totCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("totPrice"));
        totCol.setMinWidth(100);
 
        TableColumn quantityCol=new TableColumn("Qty");
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<SaleItem, String>("quantity"));
        
        table.getColumns().addAll(reviseCol,upcCol,nameCol,priceCol,totCol,quantityCol);
        table.setItems(data);
        table.setMaxWidth(750);
        table.setStyle("-fx-font-size: 16;");
        
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
        taxTextBox.setMinWidth(465);
        
        HBox taxHbox=new HBox();
        taxHbox.setSpacing(155);
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
        amountTextBox.setMinWidth(465);
        
        
        
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
		Button cancel = new Button("Cancel");
		//set the styling for the button
		cancel.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
		//create the submit button
		Button submit = new Button("Submit");
		//create the register styling
		submit.setStyle("-fx-border-color:B82F33;"
					  + "-fx-font-family: Quicksand;"
					  + "-fx-font-size: 12pt;");
						
		 final HBox hbox = new HBox();
		 hbox.setSpacing(200);
		 hbox.setPadding(new Insets(60, 0, 100, 300));
		    
		 hbox.getChildren().addAll(cancel,submit);
	    //Set content to GridPane
		
	    
	   this.setTop(addItemBox);
	    this.setCenter(vbox);
	    this.setBottom(hbox);
	  //create the scene
		
	    /**********************************************************************
		 *               Add all Action Here                           *
		 ***********************************************************************/  	
	
        //**************appleList Initializing**************from database-------
	    
	    
	    
	    
	    //add Item	    
	    addItemButton.setOnAction(e->{
			data.add(new SaleItem("0002", "FUJI", "3.0", "18"));
			
			
		});
	    
	    //Delete Item
	    
	    deleteItemButton.setOnAction(e->{
	    	for(SaleItem saleItem:data) {
	    		if(saleItem.getReviseCheck().isSelected()) {
	    			Platform.runLater(() -> {data.remove(saleItem);});
	    			}
	    	}
	    	
	    });
		
	    //reset
	   cancel.setOnAction(e->{
	    	for(SaleItem saleItem:data) {
	    		Platform.runLater(() -> {data.remove(saleItem);});
	    	}
	    	
	    });
	    //submit
	    submit.setOnAction(e->{
	    	
	    });
	    
	


  }


}

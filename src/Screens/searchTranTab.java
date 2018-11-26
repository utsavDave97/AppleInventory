package Screens;

import java.time.LocalDate;

import Screens.TableViewItems.ScreenSaleItem;
import Screens.TableViewItems.SaleRecord;
//import Screens.currentranTab.SaleItem;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class searchTranTab extends BorderPane{
	public searchTranTab() {
		
		this.setStyle("-fx-background-color: #DCDCDC;");
		

		//create the content for the Completed transaction

		
	       /**********************************************************************
	        *                Top choose and add sale Item                                  *
	        ***********************************************************************/    		
	    //Declare a hbox to holding the operations
	     HBox addItemBox=new HBox(10); 
	     addItemBox.setPadding(new Insets(20,10,20,20));
	     addItemBox.setStyle("-fx-border-color:gray;\n"
	        		+ "-fx-border-width:0 0 1 0;\n"
	        		+ "-fx-border-style:solid;");
	   
	     
	     final DatePicker datePickerTo = new DatePicker();
			//set datePicker style
	     datePickerTo.setMinHeight(40);
	     datePickerTo.setStyle("-fx-font-size:18");
			//set event for date picker
	     datePickerTo.setOnAction(new EventHandler() {
		    @Override
			public void handle(Event event) {
		    	LocalDate date = datePickerTo.getValue();
		    	
		         System.err.println("Selected date: " + date);
			}
		 });
	     
	     
	     //declare a label
	     Label toLabel=new Label("To:");
	     //set the name font
	     toLabel.setStyle("-fx-font-family: Quicksand;"
	 				  + "-fx-font-size: 12pt;");
	    
	   
	     
	     final DatePicker datePickerEnd = new DatePicker();
			//set datePicker style
	     datePickerEnd.setMinHeight(40);
	     datePickerEnd.setStyle("-fx-font-size:18");
			//set event for date picker
	     datePickerEnd.setOnAction(new EventHandler() {
		    @Override
			public void handle(Event event) {
		    	LocalDate date = datePickerTo.getValue();
		    
		         System.err.println("Selected date: " + date);
			}
		 });
	     
	     
	     
	     
	     
	     
	      //add a button to add more apple items
	      Button searchButton=new Button("Search");
	      searchButton.setStyle("-fx-border-color: B82F33;"
						 + "-fx-font-family: Quicksand;"
						 + "-fx-font-size: 12pt;");
	      addItemBox.getChildren().addAll(datePickerTo,toLabel,datePickerEnd,searchButton);
	         
	     



/**********************************************************************
 *                Table List Content                                  *
 ***********************************************************************/    
TableView<SaleRecord> table = new TableView<SaleRecord>();
 final ObservableList<SaleRecord> data =
        FXCollections.observableArrayList(
        new SaleRecord("2008", "dave", "0.3","6"));
      
       
table.setEditable(true);


TableColumn timeCol = new TableColumn("Sale Time");
timeCol.setMinWidth(200);
timeCol.setCellValueFactory(
        new PropertyValueFactory<SaleRecord, String>("saleTime"));

TableColumn nameCol = new TableColumn("Clerk");

nameCol.setCellValueFactory(
        new PropertyValueFactory<ScreenSaleItem, String>("name"));
nameCol.setMinWidth(200);


TableColumn taxCol = new TableColumn("Tax");

taxCol.setCellValueFactory(
        new PropertyValueFactory<ScreenSaleItem, String>("tax"));

taxCol.setMinWidth(150);


TableColumn totCol = new TableColumn("Total Price");


totCol.setCellValueFactory(
        new PropertyValueFactory<ScreenSaleItem, String>("total"));
totCol.setMinWidth(200);

setMinHeight(150);
  
table.getColumns().addAll(timeCol,nameCol,taxCol,totCol);
table.setItems(data);
table.setMaxWidth(750);
table.setStyle("-fx-font-size: 16;");

/**********************************************************************
 *                Bottom tax and totalAmount                           *
 ***********************************************************************/  


final VBox vbox = new VBox();
vbox.setSpacing(5);
vbox.setPadding(new Insets(30, 10, 0, 10));

vbox.getChildren().addAll(table);

//create the submit button
Button clear = new Button("Clear");
//create the register styling
clear.setStyle("-fx-border-color:B82F33;"
			  + "-fx-font-family: Quicksand;"
			  + "-fx-font-size: 12pt;");
				
 final HBox hbox = new HBox();
 hbox.setSpacing(200);
 hbox.setPadding(new Insets(60, 0, 100, 300));
    
 hbox.getChildren().addAll(clear);
//Set content to GridPane


this.setTop(addItemBox);
this.setCenter(vbox);
this.setBottom(hbox);
//create the scene


/**************************************************************************************
*         add  button event
*************************************************************************************/

//add search button action

  searchButton.setOnAction(e->{
	  
  });
  
  //add clear button
  
  clear.setOnAction(e->{
		for(SaleRecord saleRecord:data) {
    		Platform.runLater(() -> {data.remove(saleRecord);});
    	}
  });


}


}

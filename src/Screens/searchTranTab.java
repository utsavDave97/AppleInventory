package Screens;

import java.time.LocalDate;

import Screens.TableViewItems.SaleItem;
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
	     HBox addItemBox=new HBox(40); 
	     addItemBox.setPadding(new Insets(20,20,20,250));
	     addItemBox.setStyle("-fx-border-color:gray;\n"
	        		+ "-fx-border-width:0 0 1 0;\n"
	        		+ "-fx-border-style:solid;");
	     
	     TextField startTime=new TextField();
	     startTime.setEditable(false);
	     startTime.setMinSize(50, 40);
	     
	     
	     final DatePicker datePickerTo = new DatePicker();
			//set datePicker style
	     datePickerTo.setMinHeight(40);
	     datePickerTo.setStyle("-fx-font-size:18");
			//set event for date picker
	     datePickerTo.setOnAction(new EventHandler() {
		    @Override
			public void handle(Event event) {
		    	LocalDate date = datePickerTo.getValue();
		    	startTime.setText(date.toString());
		         System.err.println("Selected date: " + date);
			}
		 });
	     
	     
	     //declare a label
	     Label toLabel=new Label("To:");
	     //set the name font
	     toLabel.setStyle("-fx-font-family: Quicksand;"
	 				  + "-fx-font-size: 12pt;");
	    
	    
	     //add another time choose textfield
	     
	     TextField endTime=new TextField();
	     endTime.setEditable(false);
	     endTime.setMinSize(50, 40);
	     
	     
	     final DatePicker datePickerEnd = new DatePicker();
			//set datePicker style
	     datePickerEnd.setMinHeight(40);
	     datePickerEnd.setStyle("-fx-font-size:18");
			//set event for date picker
	     datePickerEnd.setOnAction(new EventHandler() {
		    @Override
			public void handle(Event event) {
		    	LocalDate date = datePickerTo.getValue();
		    	endTime.setText(date.toString());
		         System.err.println("Selected date: " + date);
			}
		 });
	     
	     
	     
	     
	     
	     
	      //add a button to add more apple items
	      Button searchButton=new Button("Search");
	      searchButton.setStyle("-fx-border-color: B82F33;"
						 + "-fx-font-family: Quicksand;"
						 + "-fx-font-size: 12pt;");
	      addItemBox.getChildren().addAll(startTime,datePickerTo,toLabel,endTime,datePickerEnd,searchButton);
	         
	     



/**********************************************************************
 *                Table List Content                                  *
 ***********************************************************************/    
TableView<SaleRecord> table = new TableView<SaleRecord>();
 final ObservableList<SaleRecord> data =
        FXCollections.observableArrayList(
        new SaleRecord("2008", "dave", "0.3","6"));
      
       
table.setEditable(true);


TableColumn timeCol = new TableColumn("Sale Time");
timeCol.setMinWidth(100);
timeCol.setCellValueFactory(
        new PropertyValueFactory<SaleRecord, String>("saleTime"));

TableColumn nameCol = new TableColumn("Name");

nameCol.setCellValueFactory(
        new PropertyValueFactory<SaleItem, String>("name"));

TableColumn taxCol = new TableColumn("Tax");

taxCol.setCellValueFactory(
        new PropertyValueFactory<SaleItem, String>("tax"));

TableColumn totCol = new TableColumn("Total Price");

totCol.setCellValueFactory(
        new PropertyValueFactory<SaleItem, String>("total"));


  
table.getColumns().addAll(timeCol,nameCol,taxCol,totCol);
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


/**************************************************************************************
*         add  button event
*************************************************************************************/
//add item button event
//addItemButton.setOnAction(e->{
//	    	
// data.add(new SaleItem("0002", "Fuji", "2.5", "3.2"));
//});
////delete button event
//table.setOnMouseClicked(e->{
// for(SaleItem  saleItem:data) {
//	 saleItem.getDelButton().setOnAction(chosenEvent->{
//		 Platform.runLater(() -> {data.remove(saleItem);}); 
//	 });
// }
//});
//
////add cancel button event
//cancel.setOnAction(e->{
//for(SaleItem saleItem:data) {
//	 Platform.runLater(() -> {data.remove(saleItem);}); 
//} 
// 
// 
//});



}


}

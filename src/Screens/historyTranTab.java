package Screens;

import java.time.LocalDate;

import Screens.TableViewItems.SaleHisItem;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * @description:Display the transactions made in that chosen day , transaction information
 *              can be deleted
 * @author jianqin Wang
 *
 */
public class historyTranTab extends BorderPane{
	//Define constructor 
	 public historyTranTab() {
		 //declare observableList to hold data for table View
		 final ObservableList<SaleHisItem> dataHis =FXCollections.observableArrayList();
		 /*******************************************************************************
		  *            Top Search Choice                                                *
		  ******************************************************************************/
            //define datePicker to choose time
			final DatePicker datePicker = new DatePicker();
			//set datePicker style
			datePicker.setMinHeight(40);
			datePicker.setStyle("-fx-font-size:18");
			//set event for date picker
		    datePicker.setOnAction(new EventHandler() {
		    @Override
			public void handle(Event event) {
		    	LocalDate date = datePicker.getValue();
		    	dataHis.add(new SaleHisItem(date.toString(), "Jianqin Wang", "1.3","50.2"));
		         System.err.println("Selected date: " + date);
			}
		 });
		 //Add search button   
		 Button searchButton=new Button("Search");
		 searchButton.setMinHeight(30);
		 //Declare HBox to contain datePicker and button
		 HBox searchHbox=new HBox();
		 searchHbox.setSpacing(50);
		 searchHbox.setAlignment(Pos.CENTER);
		 searchHbox.setMinWidth(700);
		 searchHbox.setPadding(new Insets(30,0,0,30));
		 //add botton line to seperate underneath content
		 searchHbox.setStyle("-fx-border-color:gray;\n" + 
		 		             "-fx-border-width:0 0 2 0;\n" + 
		 		             "-fx-border-style:solid;\n"
		 		             + "-fx-padding:20 0 20 0");
		 searchHbox.getChildren().addAll(datePicker,searchButton);
		 /*******************************************************************************
		  *            Center Table View  Content                                       *
		  ******************************************************************************/
		   //Define a table
		   TableView<SaleHisItem> hisTable=new TableView<SaleHisItem>();
		   dataHis.add(new SaleHisItem("2018-3-2", "Jianqin Wang", "1.3","50.2"));
		    hisTable.setEditable(true);
		  
		    //Define First Column title and cell factory
	        TableColumn timeCol = new TableColumn("Sold Time");
	        timeCol.setMinWidth(200);
	        timeCol.setCellValueFactory(
	        new PropertyValueFactory<SaleHisItem, String>("saleTime"));
	        
	        TableColumn operatorCol = new TableColumn("Clerk");
	        operatorCol.setMinWidth(150);
	        operatorCol.setCellValueFactory(
	                new PropertyValueFactory<SaleHisItem, String>("operater"));
	        
	        TableColumn taxCol = new TableColumn("Tax");
	        taxCol.setMinWidth(100);
	        taxCol.setCellValueFactory(
	                new PropertyValueFactory<SaleHisItem, String>("tax"));
	        
	        TableColumn totAmountCol = new TableColumn("Total Amount");
	        totAmountCol.setMinWidth(150);
	        totAmountCol.setCellValueFactory(
	         new PropertyValueFactory<SaleHisItem, String>("totAmount"));
	       

	        TableColumn checkCol = new TableColumn("Select");
	        checkCol.setMinWidth(100);
	        checkCol.setCellValueFactory(
	                new PropertyValueFactory<SaleHisItem, String>("checkDel"));
	       
		    hisTable.getColumns().addAll(checkCol,timeCol,operatorCol,taxCol,totAmountCol);
		 
		    hisTable.setItems(dataHis);
	        hisTable.setMaxWidth(750);
	        hisTable.setMaxHeight(300);
	        hisTable.setStyle("-fx-font-size: 16;");
	        /*******************************************************************************
			 *           Bottom Delete Button                                                    *
		     ******************************************************************************/
	        
	        //create the delete button
			Button delete = new Button("Delete");
			//set the styling for the button
			delete.setStyle("-fx-border-color: B82F33;"
						 + "-fx-font-family: Quicksand;"
						 + "-fx-font-size: 14pt;");
			
			
							
			 final HBox hbox = new HBox();
			
			 hbox.setPadding(new Insets(10, 0, 100,300));
			    
			 hbox.getChildren().add(delete);   
		    
			 VBox centerVbox=new VBox();
			 centerVbox.setSpacing(20);
			 centerVbox.getChildren().addAll(hisTable,hbox);
	        
	        
		 
		 this.setTop(searchHbox);
		 this.setCenter(centerVbox);
		 
       /*******************************************************************************
			 *           Delete Function                       v                     *
	   ******************************************************************************/
	   delete.setOnAction(e->{
		  //Loop to find which checkbox is selected
		  for (SaleHisItem saleHisItem : dataHis) {
			if(saleHisItem.getCheckDel().isSelected()) {
				Platform.runLater(() -> {dataHis.remove(saleHisItem);});
			}
		} 
		   
		   
		   
	   });     	 

		 
	 }


}
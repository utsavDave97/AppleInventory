package Screens;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import JavaBean.Sale;
import JavaBean.SaleItem;
import JavaBean.User;
import Screens.TableViewItems.SaleHisItem;
import Tables.SaleItemTable;
import Tables.SaleTable;
import Tables.UserTable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class historyTranTab extends BorderPane
{
	//Declare variables and objects
	SaleTable saleTable;
	//create an saleItemTable so we can reference this later
	SaleItemTable saleItemTable;
	//create an choiceDate so we can reference this later
	LocalDate choiceDate;
	//create an choiceDateStr so we can reference this later
	String choiceDateStr="";
	//create an choiceDateStr so we can reference this later
	UserTable userTable;
	User user;
	ArrayList<Sale> sales;
	ArrayList<SaleItem> saleItems;
	final ObservableList<SaleHisItem> dataHis =FXCollections.observableArrayList();
	//Declare formatter
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	//Define constructor 
	 @SuppressWarnings("unchecked")
	 
	public historyTranTab() 
	 {
		 //declare observableList to hold data for table View
		
		 /*******************************************************************************
		  *            Top Search Choice                                                *
		  ******************************************************************************/
            //define datePicker to choose time
			final DatePicker datePicker = new DatePicker();
			
			//set datePicker style
			datePicker.setMinHeight(40);
			datePicker.setStyle("-fx-font-size:18");
			
			//set event for date picker
		    datePicker.setOnAction(new EventHandler() 
		    {
		    @Override
			public void handle(Event event) {
		    	choiceDate = datePicker.getValue();
		    	choiceDateStr=choiceDate.format(formatter);
		    	//.add(new SaleHisItem(date.toString(), "Jianqin Wang", "1.3","50.2"));
		        
		    	System.err.println("Selected date: " + choiceDateStr);
			}
		 });
		    
		 //Add search button   
		 Button searchButton=new Button("Search");
		 searchButton.setMinHeight(30);
		 searchButton.setStyle("-fx-border-color:B82F33;"
				  + "-fx-font-family: Quicksand;"
				  + "-fx-font-size: 12pt;");
		 
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
	        hisTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
	   *          Register all   button events here                  
	   ******************************************************************************/
	   
		 searchButton.setOnAction(e->
		 {
			 if(choiceDateStr.isEmpty()) {
				 Alert alert=new Alert(AlertType.ERROR);
				 alert.setTitle("Time Empty Error");
	    		  alert.setHeaderText("The Time is Empty");
	    		  alert.setContentText("Please Chose Time And Search The Sale!");
	    		  alert.showAndWait();
			 }else {
				 searchSaleByDate(choiceDateStr);
			 }
		 });
		 
		 delete.setOnAction(e->
		 {
		  //Loop to find which checkbox is selected
		  for (SaleHisItem saleHisItem : dataHis) {
			if(saleHisItem.getCheckDel().isSelected()) {
				//Step 1:First Alert dialog to ask user whether make sure to delete
				Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm to Delete");
				alert.setHeaderText("Are You Sure to Delete the Data?");
				alert.setContentText("Confirm will Delete Data From Database!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					//Step2:Second remove items in screen
					Platform.runLater(() -> {dataHis.remove(saleHisItem);});
				    //Step 3: delete sale Items in sale Item table
					int saleId=saleHisItem.getSaleId();	
					deleteSaleItemBySaleId(saleId);
					
					//Step 4: Delete sale from sale table
					deleteSaleBySaleId(saleId);
					
				} else {
				  
				}
				
			}
		} 
		
	   });     	 

	 }//End of constructor
	
		
	 /**************************************************************************************
	 *      All functions which operate database tables through *table under Tables package 
	 *************************************************************************************/
	 
	 private String getUsername(int email_id) {
		 userTable=new UserTable();
		 user=userTable.getUser(email_id);
		String userName=user.getFirstname()+" "+user.getLastname();
		 return userName;
	 } 
	 
	 public void searchSaleByDate(String choiceDateStr) {
		    saleTable=new SaleTable();
			sales=saleTable.getAllSales();
			for (Sale sale : sales) {
				String soldTimeWithDate=sale.getSale_time().substring(0, 10);
				if(soldTimeWithDate.compareTo(choiceDateStr)==0) {
				 String	name=getUsername(sale.getEmail_id());
				 dataHis.add(new SaleHisItem(sale.getSale_time(), name, sale.getTax()+"", sale.getTotal()+"", sale.getSale_Id()));
				 
				}
			}
			
			
	 }
	 //delete sale record in the sale table
	public void deleteSaleBySaleId(int saleId) {
		Sale sale=saleTable.getSale(saleId);
		saleTable.deleteSale(sale);
	}
	//delte sale items in sale items by sale id
	public void deleteSaleItemBySaleId(int saleId) {
		saleItemTable=new SaleItemTable();
		saleItemTable.deleteSomeSaleItems(saleId);
		
	}

}
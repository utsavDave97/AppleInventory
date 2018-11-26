package Screens;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import Database.DBConnection;
import JavaBean.Product;
import JavaBean.Sale;
import JavaBean.SaleItem;
import Screens.TableViewItems.EditingCell;
import Screens.TableViewItems.ScreenSaleItem;
import Tables.ProductTable;
import Tables.SaleItemTable;
import Tables.SaleTable;
import Tables.UserTable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import sun.net.NetworkServer;
public class currentranTab extends BorderPane{
	//Declare variable for new transaction screen
	ArrayList <Product> products;
	ArrayList<Sale> sales;
	ArrayList<SaleItem> saleItems;
	ArrayList<Integer> saleItemId;
	ProductTable productTable;
	SaleTable saleTable;
	SaleItemTable saleItemTable;
	UserTable userTable;
	//According to HST of year of 2016
	private final float  TAXRATE=0.13f;
	private double endTotalAmount=0;
	private double endTax=0;
	
	 final ObservableList<ScreenSaleItem> data =
	            FXCollections.observableArrayList();
	
	//Constructor 
	@SuppressWarnings("unchecked")
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
          
      
      // Create the Combobox for user choose
		ComboBox<Product> comboApples=new ComboBox<>();
	    initialateProducts();
		comboApples.setItems(FXCollections.observableArrayList(products));

      //Give the first default selection item
      comboApples.getSelectionModel().selectFirst();
      //Set List Style Font
      comboApples.setStyle(" -fx-font-family: Quicksand;"
				  + "-fx-font-size: 12pt;");
      // Set the Size of the ComoBox
      comboApples.setPrefSize(200, 30);
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
      
      
      addItemBox.getChildren().addAll(comboApples,addItemButton,deleteItemButton);
         


	    /**********************************************************************
		 *                Table List Content                                  *
		 ***********************************************************************/    
	    TableView<ScreenSaleItem> table = new TableView<ScreenSaleItem>();
	    
	           
	    table.setEditable(true);
	  
	    TableColumn reviseCol=new TableColumn("Check");
        reviseCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("reviseCheck"));
        reviseCol.setMinWidth(100);
        TableColumn upcCol = new TableColumn("ProdID");
        upcCol.setMinWidth(100);
        upcCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("upcNumber"));
        
        TableColumn nameCol = new TableColumn("Name");
       
        nameCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("name"));
        nameCol.setMinWidth(200);
        
        TableColumn priceCol = new TableColumn("Price");
        
        priceCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("price"));
        priceCol.setMinWidth(100);
        
       TableColumn totCol = new TableColumn("Total Price");
        
       totCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("totPrice"));
        totCol.setMinWidth(100);
        totCol.setEditable(true);
        
        
       // TableColumn quantityCol=new TableColumn("Qty");
        TableColumn<ScreenSaleItem, String> quantityCol=new TableColumn<ScreenSaleItem, String>("Qty");
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<ScreenSaleItem, String>("quantity"));
     //Create a cell Editting object
        Callback<TableColumn<ScreenSaleItem, String>, TableCell<ScreenSaleItem, String>> cellFactory = (
                TableColumn<ScreenSaleItem, String> p) -> new EditingCell();
         
      //bind the EditingCell to the value          
      quantityCol.setCellFactory(cellFactory);
      
      //Setting content commit event ,so when we edit the content, it will refresh with the new value, not the old value
      quantityCol.setOnEditCommit((CellEditEvent<ScreenSaleItem, String> t) -> {
          ((ScreenSaleItem) t.getTableView().getItems().get(t.getTablePosition().getRow()))
              .setQuantity(t.getNewValue());
         
          //dynamically set the total value
          ScreenSaleItem select=(ScreenSaleItem) t.getTableView().getItems().get(
              t.getTablePosition().getRow());
          //get value from quantity column
          
        int quantityNum=Integer.parseInt(select.getQuantity());
        //get value from price column
        float priceNum=Float.parseFloat(select.getPrice());
        //calculate total price and set it two that column
        float totalPrice=quantityNum*priceNum;
        DecimalFormat df = new DecimalFormat("####0.00");
        totalPrice=Float.parseFloat(df.format(totalPrice));
          select.setTotPrice(totalPrice+"");
          
          
        });

        quantityCol.setMinWidth(150);
        
        
        
        table.getColumns().addAll(reviseCol,upcCol,nameCol,priceCol,totCol,quantityCol);
        table.setItems(data);
        table.setMaxWidth(750);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
	    
        
	    //create the calculate button
		Button calculate = new Button("Calculate");
		//set the styling for the button
		calculate.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
       
	    //create the reset button
		Button reset = new Button("Reset");
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
		 hbox.setSpacing(150);
		 hbox.setPadding(new Insets(60, 0, 100, 80));
		    
		 hbox.getChildren().addAll(calculate,reset,submit);
	    //Set content to GridPane
		
	    
	   this.setTop(addItemBox);
	    this.setCenter(vbox);
	    this.setBottom(hbox);
	  //create the scene
		
	    /**********************************************************************
		 *               Register all Action Here                           *
		 ***********************************************************************/  	
	
       
	   //Add new item to sale list in the screen(not in database) 
	    addItemButton.setOnAction(e->{
	    	
	    	  
			data.add(new ScreenSaleItem(comboApples.getSelectionModel().getSelectedItem().getProd_Id(),
					comboApples.getSelectionModel().getSelectedItem().getProd_name(),
					comboApples.getSelectionModel().getSelectedItem().getProd_price(),"0","0"));
		
			
		});
	    
	    //Delete Item from screen(not from database)
	    
	    deleteItemButton.setOnAction(e->{
	    	for(ScreenSaleItem saleItem:data) {
	    		if(saleItem.getReviseCheck().isSelected()) {
	    			Platform.runLater(() -> {data.remove(saleItem);});
	    			}
	    	}
	    	
	    });
		
	    //reset
	   reset.setOnAction(e->{
	    	for(ScreenSaleItem saleItem:data) {
	    		Platform.runLater(() -> {data.remove(saleItem);});
	    	}
	    	
	    });
	    //submit
	    submit.setOnAction(e->{
	    	
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Submit The New Transaction");
	    	alert.setHeaderText("Submit an Save the transaction");
	    	alert.setContentText("Are you Sure to Submit?");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    	 	
	    	    //Step 1: insert the new transaction record in screen into 	 Sale table of database
	    	    	int saleId;
	    	    	saleId=insertSaleIntoTable();
	    	    	System.out.println("Sale id is: "+saleId);
	    	    	
	    	    //Step 2: Insert all the sale item into Sale Item table of database
	    	    	insertSaleItemIntoTable(saleId);
	    	} 
	    	else {//do nothing
	    			    	}
	  
	    	
	    });
	    
	    //calculate the tax and total amount
	    calculate.setOnAction(e->{
	    	endTotalAmount=0;
	    	endTax=0;
	    	float totalPrice=0;
	    	//iterate to get the total price
	    	for (ScreenSaleItem screenSaleItem : data) {
	    		totalPrice+=Float.parseFloat(screenSaleItem.getTotPrice());
			    }
	    	endTax=totalPrice*TAXRATE;
	    	endTotalAmount+=totalPrice+endTax;
	    	DecimalFormat df = new DecimalFormat("####0.00");
	    	endTax=Double.parseDouble(df.format(endTax));
	        endTotalAmount=Double.parseDouble(df.format(endTotalAmount));
	    	//set to screen
	    	taxText.setText(endTax+"");
	    	totAmountText.setText(endTotalAmount+"");
	    	
	    });

  }
	//End of constructor method
	

	

    /**********************************************************************************************************
	 *               Add all Methods here including inter_opertation with database     
	 *                                     *
	 ***************************************************************************************************************/  	
	   //**************appleList Initializing**************from database-------
    
   	public void initialateProducts() {
	   productTable=new ProductTable();
	   products=productTable.getAllProducts();
	}
	
   	//Insert the sale transaction to saleTable in the database
   	public int insertSaleIntoTable() {
   	 saleTable=new SaleTable();
   	 
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	  // dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	   Date date = new Date();
     String  dateStr =dateFormat.format(date);
	   System.out.println(dateStr);
   	 
   	 Sale newSale=new Sale();
   	 newSale.setEmail_id(1);//wait for jonathon's login, i can grab the user's email id
   	 newSale.setSale_time(dateStr);
   	 newSale.setTax(endTax);
   	 newSale.setTotal(endTotalAmount);
   	 int saleId=saleTable.createSale(newSale);
   	 
   		return saleId;
   	}
	//Insert the sale item into sale item table of database
   	public void insertSaleItemIntoTable(int saleId) {
   		saleItemTable=new SaleItemTable();
   		
   		for (ScreenSaleItem screenSaleItem : data) {
   			SaleItem saleItem=new SaleItem();
   			saleItem.setSale_Id(saleId);
   			saleItem.setProd_Id(screenSaleItem.getUpcNumber());
   			saleItem.setSale_qty(Integer.parseInt(screenSaleItem.getQuantity()));
		 	saleItemTable.createSaleItem(saleItem);
		
   		}
   		
   	}
	
	


}

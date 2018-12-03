package Screens;
import java.nio.DoubleBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import JavaBean.Sale;
import JavaBean.User;
import Tables.SaleTable;
import Tables.UserTable;
import Screens.TableViewItems.SaleHisItem;
import Screens.TableViewItems.SaleRecord;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class searchTranTab extends BorderPane
{
	//Declare variables
	LocalDate startDate,endDate;
	String startDateStr="",endDateStr="";
	SaleTable saleTable;
	UserTable userTable;
	User user;
	ArrayList<Sale> sales;

	final ObservableList<SaleRecord> data = FXCollections.observableArrayList();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@SuppressWarnings({ "unchecked", "rawtypes" })

	public searchTranTab() 
	{

		this.setStyle("-fx-background-color: #DCDCDC;");

		/**********************************************************************
		 *                Top Search conditions component                             *
		 ***********************************************************************/    		
		//Declare a hbox to holding the operations
		HBox addItemBox=new HBox(19); 
		addItemBox.setPadding(new Insets(10,10,5,10));

		final DatePicker datePickerTo = new DatePicker();
		//set datePicker style
		datePickerTo.setMinHeight(40);
		datePickerTo.setStyle("-fx-font-size:18");
		datePickerTo.setMaxWidth(230);

		//set event for date picker
		datePickerTo.setOnAction(new EventHandler() 
		{
			@Override
			public void handle(Event event) {
				startDate = datePickerTo.getValue();
				startDateStr=startDate.format(formatter);

			}
		});

		//declare a label
		Label tiemFromLabel=new Label("Date:    ");

		//set the name font
		tiemFromLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		//declare a label
		Label toLabel=new Label("To:");
		//set the name font
		toLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		final DatePicker datePickerEnd = new DatePicker();
		//set datePicker style
		datePickerEnd.setMinHeight(40);
		datePickerEnd.setMaxWidth(230);
		datePickerEnd.setStyle("-fx-font-size:18");
		//set event for date picker
		datePickerEnd.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				endDate = datePickerEnd.getValue();
				endDateStr=endDate.format(formatter);
				System.out.println(endDateStr+" "+endDateStr.length());
				if(endDateStr.compareTo(startDateStr)<0) {
					datePickerEnd.setValue(startDate);
					endDateStr=startDateStr;
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Input Time Error");
					alert.setHeaderText("End Time Before Start Time");
					alert.setContentText("Please Chose End Time Again,It Should be After Start Time!");
					alert.showAndWait();
				}

			}
		});


		//add a button to Search
		Button searchButton=new Button("Search");
		searchButton.setStyle("-fx-border-color: B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");
		addItemBox.getChildren().addAll(tiemFromLabel,datePickerTo,toLabel,datePickerEnd);

		//add total amount arrange choices for user
		//if user tickle this checkbox, total amount will be as conditions for 
		CheckBox checkBox=new CheckBox();
		checkBox.setSelected(false);

		//declare textfield for user to input
		TextField minTotalAmount=new TextField("0");
		minTotalAmount.setMinHeight(40);
		minTotalAmount.setStyle("-fx-font-size:18");

		//declare a label
		Label amountFromLabel=new Label("Amount:");

		//set the name font
		amountFromLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		//declare a label
		Label amountToLabel=new Label("To:");

		//set the name font
		amountToLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		TextField maxTotalAmount=new TextField("0");
		maxTotalAmount.setMinHeight(40);
		maxTotalAmount.setStyle("-fx-font-size:18");

		HBox amountChoiceHbox=new HBox(15);
		amountChoiceHbox.getChildren().addAll(amountFromLabel,minTotalAmount,amountToLabel,maxTotalAmount,checkBox,searchButton);

		amountChoiceHbox.setPadding(new Insets(5,10,10,10));
		amountChoiceHbox.setStyle("-fx-border-color:gray;\n"
				+ "-fx-border-width:0 0 1 0;\n"
				+ "-fx-border-style:solid;");

		VBox searchConditionsVbox=new VBox(10);
		searchConditionsVbox.getChildren().addAll(addItemBox,amountChoiceHbox);
		searchConditionsVbox.setAlignment(Pos.BOTTOM_LEFT);

		/**********************************************************************
		 *                Table List Content                                  *
		 ***********************************************************************/  

		TableView<SaleRecord> table = new TableView<SaleRecord>();



		TableColumn timeCol = new TableColumn("Sold Time");
		timeCol.setMinWidth(200);
		timeCol.setCellValueFactory(
				new PropertyValueFactory<SaleRecord, String>("saleTime"));

		TableColumn nameCol = new TableColumn("Clerk");

		nameCol.setCellValueFactory(
				new PropertyValueFactory<SaleRecord, String>("name"));
		nameCol.setMinWidth(150);


		TableColumn taxCol = new TableColumn("Tax");

		taxCol.setCellValueFactory(
				new PropertyValueFactory<SaleRecord, String>("tax"));

		taxCol.setMinWidth(100);


		TableColumn totCol = new TableColumn("Total Price");


		totCol.setCellValueFactory(
				new PropertyValueFactory<SaleRecord, String>("total"));
		totCol.setMinWidth(100);

		setMinHeight(150);

		TableColumn checkCol = new TableColumn("Detail");


		checkCol.setCellValueFactory(
				new PropertyValueFactory<SaleRecord, String>("checkDetail"));
		checkCol.setMinWidth(80);

		setMinHeight(150);
		table.getColumns().addAll(checkCol,timeCol,nameCol,taxCol,totCol);
		table.setItems(data);
		table.setMaxWidth(750);
		table.setStyle("-fx-font-size: 16;");
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
		//create the submit button
		Button detailButton = new Button("Detail");
		//create the register styling
		detailButton.setStyle("-fx-border-color:B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");				
		final HBox hbox = new HBox(200);

		hbox.setPadding(new Insets(10, 0, 80, 200));

		hbox.getChildren().addAll(detailButton,clear);
		//Set content to GridPane


		this.setTop(searchConditionsVbox);
		this.setCenter(vbox);
		this.setBottom(hbox);
		//create the scene


		/**************************************************************************************
		 *       Register Button event here  
		 *************************************************************************************/

		//add search button action
		searchButton.setOnAction(e->{
			//if checkBox is selected
			//Step 1:Decide total amount arrange input by user is valid
			//Step 2:Show search according to both total amount arrange and date arrange

			if(checkBox.isSelected()) 
			{
				double doubleMaxTotalAmount=Double.parseDouble(maxTotalAmount.getText());
				double doubleMinTotalAmount=Double.parseDouble(minTotalAmount.getText());
				//Decide whether user set the time
				if((doubleMaxTotalAmount<doubleMinTotalAmount)||
						(endDateStr.isEmpty())||
						(startDateStr.isEmpty())) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Input Amount Error");
					alert.setHeaderText("Check Your Search Condition");
					alert.setContentText("You should choice Date or Max Amount should be more than Min Amount !");
					alert.showAndWait();

				}else {
					System.out.println(startDateStr+":"+endDateStr+":"+doubleMinTotalAmount+":"+doubleMaxTotalAmount);
					showByAmountAndDate(doubleMinTotalAmount,doubleMaxTotalAmount,startDateStr, endDateStr);
				} 

			}else
			{
				if((endDateStr.isEmpty())||(startDateStr.isEmpty())) {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Input Amount Error");
					alert.setHeaderText("Check Your Search Condition");
					alert.setContentText("You should choice Date!");
					alert.showAndWait();

				}		  
				showSales(startDateStr, endDateStr);}

		});

		//add clear button

		clear.setOnAction(e->{
			for(SaleRecord saleRecord:data) {
				Platform.runLater(() -> {data.remove(saleRecord);});
			}
		});

		detailButton.setOnAction(e->{
			for (SaleRecord saleRecord : data) {
				if(saleRecord.getCheckDetail().isSelected()) {
					System.out.println(saleRecord.getSaleId());
					new searchDetailPopup(saleRecord.getSaleId());
				}
			}
		});


	}//Constructor method ends


	/**************************************************************************************
	 *      All functions which operate database tables through *table under Tables package 
	 *************************************************************************************/
	//Get the user name name through email id 
	private String getUsername(int email_id) {
		userTable=new UserTable();
		user=userTable.getUser(email_id);
		String userName=user.getFirstname()+" "+user.getLastname();
		return userName;
	}

	private void showSales(String startDateStr,String endDateStr){
		//Clear the data of last search
		for (SaleRecord saleRecord : data) {
			Platform.runLater(() -> {data.remove(saleRecord);});
		}
		saleTable=new SaleTable();
		sales=saleTable.getAllSales();
		//This is array showed in table view
		//saleRecords=new ArrayList<SaleRecord>();
		for (Sale sale : sales) {
			String soldTimeWithDate=sale.getSale_time().substring(0, 10);

			//If the sales' sold time between start date and end date, add it to saleRecords arraylist
			if((soldTimeWithDate.compareTo(startDateStr)>=0)&&
					soldTimeWithDate.compareTo(endDateStr)<=0) {
				String name=getUsername(sale.getEmail_id());
				data.add(new SaleRecord(sale.getSale_time(), name, sale.getTax()+"", sale.getTotal()+"",sale.getSale_Id()));
			}

		}

	}

	public void showByAmountAndDate(double doubleMinTotalAmount,double doubleMaxTotalAmount,String startDateStr,String endDateStr) {
		//Clear the data of last search
		for (SaleRecord saleRecord : data) {
			Platform.runLater(() -> {data.remove(saleRecord);});
		}

		saleTable=new SaleTable();
		sales=saleTable.getAllSales();
		//This is array showed in table view
		//saleRecords=new ArrayList<SaleRecord>();
		for (Sale sale : sales) {
			String soldTimeWithDate=sale.getSale_time().substring(0, 10);
			Double soldAmout=sale.getTotal();
			System.out.println("sale time is: "+soldTimeWithDate);
			//If the sales' sold time between start date and end date, add it to saleRecords arraylist
			if((soldTimeWithDate.compareTo(startDateStr)>=0)&&
					(soldTimeWithDate.compareTo(endDateStr)<=0)&&
					(soldAmout>=doubleMinTotalAmount)&&
					(soldAmout<=doubleMaxTotalAmount)) {
				String name=getUsername(sale.getEmail_id());
				data.add(new SaleRecord(sale.getSale_time(), name, sale.getTax()+"", sale.getTotal()+"",sale.getSale_Id()));
			}

		}
	}
}

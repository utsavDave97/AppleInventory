package Screens;

import JavaBean.User;
import Tables.ProductTable;
import Tables.SaleItemTable;
import Tables.UserRoleTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class statisticScreen
{

	public statisticScreen() 
	{

		User loggedInuser =  logInScreen.getUserInstance();
		/**
		 * create the content for statistic screen 
		 */

		//create a stage to hold the content
		Stage stage = new Stage();

		//create the borderPane to store the information we want to store
		BorderPane borderpane = new BorderPane();

		//set the style for the borderpane
		borderpane.setStyle("-fx-background-color: DCDCDC");

		borderpane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");

		//create the vbox to hold the piechart and the dropdown box of currently available products
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);

		//create the content be inside the vbox
		Text title = new Text("Sales Total to date");

		//set the size of the title text
		title.setStyle("-fx-font-Size: 45; -fx-font-family: Quicksand");


		SaleItemTable saleitemtable = new SaleItemTable();
		ProductTable productTable = new ProductTable();
		System.out.println(saleitemtable.grabAllSoldProdId());

		/**
		 * create a forloop to add data to the piechart from data inside the sale table
		 */

		//create the piechart data for the piechart
		ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
		//create the function to create a new field for each graph
		for(int i = 1; i <= saleitemtable.grabAllSoldProdId(); i++) {
			pieData.add(saleitemtable.addPieData(i));
		}				

		//create the piechart using the data above
		PieChart piechart = new PieChart(pieData);

		//set the start angle of the piechart
		piechart.setStartAngle(90);

		//set the line length of the line's
		piechart.setLabelLineLength(25);

		//set the visibilty of the lines for the piechart
		piechart.setLabelsVisible(true);

		//set the direction of the piechart
		piechart.setClockwise(true);

		//add the content to the hbox
		vbox.getChildren().add(title);
		vbox.getChildren().add(piechart);

		borderpane.setCenter(vbox);
		Scene scene = new Scene(borderpane,1064,762);

		/**
		 * create the content for the navigation bar
		 */

		ToggleButton navigationButton = new ToggleButton();
		ImageView menuImage = new ImageView("menu.png");
		navigationButton.setGraphic(menuImage);

		//Creating space between navigation button and log out button
		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		final Pane spacer2 = new Pane();
		HBox.setHgrow(spacer2, Priority.ALWAYS);

		//Creating logOutButton and setting its image
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);

		logOutButton.setOnAction(e->{
			new logInScreen();
			stage.close();
		});

		Label heading = new Label("AppleCore INC.");
		heading.setStyle("-fx-text-fill: #B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 30;");

		//Creating toolBar and adding navigation button and logout button to it
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer2, heading,spacer,logOutButton);

		//create a button for a newtransaction inside the nav
		Button newTransaction = new Button("New Transaction");
		//create a button for a new completed transaction inside the nav
		Button completedTransaction = new Button("Completed Transaction");
		//create a addStock for a newtransaction inside the nav
		Button addStock = new Button("Add Stock");
		//create a updateStock for a newtransaction inside the nav
		Button updateStock = new Button("Update Stock");
		//create a deleteStock for a newtransaction inside the nav
		Button deleteStock = new Button("Delete Stock");
		//create a accountManagement for a newtransaction inside the nav
		Button accountManagement = new Button("Account Management");
		//create a statisticScreen for a newtransaction inside the nav
		Button statisticScreen = new Button("Statistic Screen");

		//If the user is clerk role, who cann't visit accountManager functionality
				User loginUser=logInScreen.getUserInstance();
				UserRoleTable userRoleTable=new UserRoleTable();
				
				if(userRoleTable.getRoleId(loginUser.getEmail_id())==1) {
					statisticScreen.setVisible(false);
					accountManagement.setVisible(false);
				}else if(userRoleTable.getRoleId(loginUser.getEmail_id())==2) {
					accountManagement.setVisible(false);
				}
				
				
				VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, deleteStock,statisticScreen, accountManagement);
				
				
				
				
				borderpane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				borderpane.setLeft(null);
			}
		});

		navigationButton.setOnAction(e->{
			borderpane.setLeft(menu);
		});

		newTransaction.setOnAction(e->{
			new newTransactionScreen();
			stage.close();
		});

		completedTransaction.setOnAction(e->{
			new completedTranScreen();
			stage.close();
		});

		addStock.setOnAction(e->{
			new addStockScreen();
			stage.close();
		});

		updateStock.setOnAction(e->{
			new updateStockScreen();
			stage.close();
		});

		accountManagement.setOnAction(e->{
			new accountManagementScreen();
			stage.close();
		});

		statisticScreen.setOnAction(e->{
			new statisticScreen();
			stage.close();
		});

		deleteStock.setOnAction(e->{
			new deleteStockScreen();
			stage.close();
		});

		logOutButton.setOnAction(e->{
			new logInScreen();
			stage.close();
		});

		borderpane.setTop(navigationToolBar);
		stage.setScene(scene);
		stage.show();
	}

}

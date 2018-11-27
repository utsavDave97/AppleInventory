package Screens;


import Screens.TableViewItems.ScreenSaleItem;
import Screens.TableViewItems.ScreenUser;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;

public class accountManagementScreen{

	public accountManagementScreen() {
		
		
		
		//create a stage to hold the content
		Stage stage = new Stage();
		
		
		BorderPane pane = new BorderPane();
		//create an hbox for the remove and save changes button
		HBox hbox = new HBox();
		//create the two button for the hbox.
		hbox.setSpacing(20);
		Button remove = new Button("Remove");
		Button saveChanges = new Button("Save Changes");
		//add the buttons to the hbox
		hbox.getChildren().addAll(remove, saveChanges);
		//set the alignment of the hbox
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		//create padding for the hbox
		hbox.setPadding(new Insets(0, 0, 20, 0));
		
		/*********************************************************
		 * Create the contents for the account management screen
		 *********************************************************/
		TableView<ScreenUser> table = new TableView<ScreenUser>();
		ObservableList<ScreenUser> dummyData =
	            FXCollections.observableArrayList(
	            new ScreenUser(1, "jonathanstevanka@gmail.com", "jonathan", "stevanka"),
        			new ScreenUser(2, "hannahpunga@gmail.com", "hannah", "punga"),
        			new ScreenUser(3, "daveutsav@gmail.com", "dave", "utsav"),
        			new ScreenUser(4, "jonnybauer@gmail.com", "jonny", "bauer"));

		table.setEditable(true);
		
		TableColumn idCol = new TableColumn("UserID:");
		idCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, Integer>("email_id"));
		idCol.setMinWidth(65);
		idCol.setMaxWidth(150);
		
		TableColumn emailCol = new TableColumn("Email:");
		emailCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("email"));
		emailCol.setMinWidth(245);
		
		TableColumn fnameCol = new TableColumn("First name:");
		fnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("fname"));
		fnameCol.setMinWidth(150);
		
		TableColumn lnameCol = new TableColumn("Last name:");
		lnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("lname"));
		lnameCol.setMinWidth(150);
		
		ObservableList<String> roles = FXCollections.observableArrayList(); 
		roles.add("clerk");
		roles.add("manager");
		roles.add("administrator");
		
		TableColumn comboCol = new TableColumn("Role:");
		comboCol.setCellValueFactory(new PropertyValueFactory<>("role"));
		comboCol.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(),roles));
		comboCol.setMinWidth(230);
		
		
		
		
		table.getColumns().addAll(idCol, emailCol, fnameCol, lnameCol, comboCol);
		table.setItems(dummyData);
		table.setMaxWidth(1000);
		table.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
		//table.setMinWidth(300);
		table.setMaxHeight(500);
		table.setStyle("-fx-font-size: 16;");
		
		pane.setCenter(table);
		
		Scene scene = new Scene(pane, 1064, 762);
		
		
		
		
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
		
		Label heading = new Label("AppleCore INC.");
		heading.setStyle("-fx-text-fill: #B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 30;");
		
		//Creating logOutButton and setting its image
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);
		
		logOutButton.setOnAction(e->{
			new logInScreen();
			stage.close();
		});
		
		//Creating toolBar and adding navigation button and logout button to it
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer2,heading,spacer,logOutButton);
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Competed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		Button accountManagement = new Button("Account Management");
		Button statisticScreen = new Button("Statistic Screen");

		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, accountManagement, statisticScreen, deleteStock);
		
	    navigationButton.setOnAction(e->{
	    	pane.setLeft(menu);
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
		
		pane.setTop(navigationToolBar);
		pane.setBottom(hbox);
		stage.setScene(scene);
		stage.show();
		
		
		
		
		
		
	}

}

package Screens;


import java.util.ArrayList;

import JavaBean.User;
import JavaBean.UserRole;
import Screens.TableViewItems.EditCellAccountManagement;
import Screens.TableViewItems.EditingCell;
import Screens.TableViewItems.ScreenSaleItem;
import Screens.TableViewItems.ScreenUser;
import Tables.UserTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

public class accountManagementScreen{
	int position=0;

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
		TableView<ScreenUser> table = new TableView<>();
		table.setEditable(true);
		ObservableList<ScreenUser> userData = FXCollections.observableArrayList();
		UserTable usertable = new UserTable();
	    //create functions here to create new ScreenUser's based on information from the database
		ArrayList<ScreenUser> list = new ArrayList<ScreenUser>();
		list = usertable.getAllUsersForTableView();
	    for(int i=0; i< list.size(); i++ ) {
	    		userData.add(list.get(i));
	    }
		

		
		TableColumn idCol = new TableColumn("UserID:");
		idCol.setEditable(false);
		idCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, Integer>("email_id"));
		idCol.setMinWidth(65);
		idCol.setMaxWidth(150);
		
		Callback<TableColumn<ScreenUser, String>, TableCell<ScreenUser, String>> cellFactory = (
				TableColumn<ScreenUser, String> p) -> new EditCellAccountManagement();
		
		
		TableColumn<ScreenUser, String> emailCol = new TableColumn("Email:");
		emailCol.setEditable(true);
		emailCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("email"));
		emailCol.setMinWidth(245);
		emailCol.setCellFactory(cellFactory);
		
		TableColumn<ScreenUser, String> fnameCol = new TableColumn("First name:");
		fnameCol.setEditable(true);
		fnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("fname"));
		fnameCol.setMinWidth(150);
		fnameCol.setCellFactory(cellFactory);
		
		TableColumn<ScreenUser, String> lnameCol = new TableColumn("Last name:");
		lnameCol.setEditable(true);
		lnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("lname"));
		lnameCol.setMinWidth(150);
		lnameCol.setCellFactory(cellFactory);
		
		ObservableList<String> roles = FXCollections.observableArrayList(); 
		roles.add("clerk");
		roles.add("manager");
		roles.add("administrator");
		
		TableColumn<ScreenUser, String> comboCol = new TableColumn("Role:");
		comboCol.setVisible(true);
		comboCol.setCellValueFactory(new PropertyValueFactory<>("role"));
		comboCol.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(),roles));
		comboCol.setMinWidth(230);
		//ComboBoxTableCell.forTableColumn(new DefaultStringConverter().roles)).
		
		table.getColumns().addAll(idCol, emailCol, fnameCol, lnameCol, comboCol);
		table.setItems(userData);
		table.setMaxWidth(1000);
		table.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
		//table.setMinWidth(300);
		table.setMaxHeight(500);
		table.setStyle("-fx-font-size: 16;");
		/**
		 * create the onclick listieners for the editcell's
		 */
		User proposedChanges = new User();
		UserRole userrole = new UserRole();
		User savedUser = new User();
		

		
		emailCol.setOnEditCommit((TableColumn.CellEditEvent<ScreenUser, String> t) -> { 
			
			ScreenUser cursor=(ScreenUser) t.getTableView().getItems().get(
					t.getTablePosition().getRow());
			position = cursor.getEmail_id();

			
			savedUser.setEmail_id(cursor.getEmail_id());
			savedUser.setEmail(cursor.getEmail());
			savedUser.setFirstname(cursor.getFname());
			savedUser.setLastname(cursor.getLname());
			
			//change the email at the designated spot
			((ScreenUser) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
			

			savedUser.setEmail_id(cursor.getEmail_id());
			savedUser.setEmail(cursor.getEmail());
			
//			proposedChanges.setEmail_id(cursor.getEmail_id());
//			proposedChanges.setEmail(cursor.getEmail());
			
			
			
	

		});
		
		
		fnameCol.setOnEditCommit((TableColumn.CellEditEvent<ScreenUser, String> t) -> {
			ScreenUser cursor=(ScreenUser) t.getTableView().getItems().get(
					t.getTablePosition().getRow());
			
			position = cursor.getEmail_id();

			
			savedUser.setEmail_id(cursor.getEmail_id());
			savedUser.setEmail(cursor.getEmail());
			savedUser.setFirstname(cursor.getFname());
			savedUser.setLastname(cursor.getLname());
			
			((ScreenUser) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFname(t.getNewValue());
			
			savedUser.setFirstname(cursor.getFname());
			
			proposedChanges.setEmail_id(cursor.getEmail_id());
			proposedChanges.setFirstname(cursor.getFname());

			
		});
		
		lnameCol.setOnEditCommit((TableColumn.CellEditEvent<ScreenUser, String> t) -> {
			
			ScreenUser cursor=(ScreenUser) t.getTableView().getItems().get(
					t.getTablePosition().getRow());
			
			position = cursor.getEmail_id();

			
			savedUser.setEmail_id(cursor.getEmail_id());
			savedUser.setEmail(cursor.getEmail());
			savedUser.setFirstname(cursor.getFname());
			savedUser.setLastname(cursor.getLname());
			
			((ScreenUser) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLname(t.getNewValue());

			savedUser.setLastname(cursor.getLname());
			
			proposedChanges.setEmail_id(cursor.getEmail_id());
			proposedChanges.setLastname(cursor.getLname());
			
		});
		
		
		comboCol.setOnEditCommit((TableColumn.CellEditEvent<ScreenUser, String> t) -> {
			ScreenUser cursor=(ScreenUser) t.getTableView().getItems().get(
					t.getTablePosition().getRow());
			
			
			
		});
		
		
		saveChanges.setOnAction(e->{
			
			System.out.println(savedUser.getEmail());
			System.out.println(savedUser.getEmail_id());
			System.out.println(savedUser.getFirstname());
			System.out.println(savedUser.getLastname());

			usertable.updateUser(savedUser);
			 
//			proposedChanges.setEmail(null);
//			proposedChanges.setFirstname(null);
//			proposedChanges.setLastname(null);
//			proposedChanges.setEmail_id(0);
			
			new accountManagementScreen();
			stage.close();
		});
		
		
		//position = selectedRow.getEmail_id();
		remove.setOnAction(e->{
			ScreenUser selectedRow = table.getSelectionModel().getSelectedItem();
			position = selectedRow.getEmail_id();
			usertable.deleteUser(position);
			new accountManagementScreen();
			stage.close();
		});
		
		
		
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

		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, statisticScreen, deleteStock, accountManagement);
		
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				pane.setLeft(null);
			}
		});
		
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

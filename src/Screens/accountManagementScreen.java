package Screens;


import java.util.ArrayList;

import JavaBean.User;
import JavaBean.UserRole;
import Screens.TableViewItems.EditCellAccountManagement;
import Screens.TableViewItems.EditingCell;
import Screens.TableViewItems.Position;
import Screens.TableViewItems.ScreenSaleItem;
import Screens.TableViewItems.ScreenUser;
import Tables.UserRoleTable;
import Tables.UserTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class accountManagementScreen
{
	//create a public position integer so the onEditCommits can make use of this later on for the remove button
	int position=0;

	UserRoleTable userRoleTable;

	public accountManagementScreen() 
	{
		

		
		//create a stage to hold the content

		Stage stage = new Stage();
				
		//create the borderpane to hold the content
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
		//create the table to hold the information.
		TableView<ScreenUser> table = new TableView<>();
		//create the table to seteditable to true
		table.setEditable(true);
		//create the observableList to hold the data for the table
		ObservableList<ScreenUser> userData = FXCollections.observableArrayList();
		//create a new usertable
		UserTable usertable = new UserTable();
		
	    //create functions here to create new ScreenUser's based on information from the database
		ArrayList<ScreenUser> list = new ArrayList<ScreenUser>();
		//use the function to grab all of the information inside our database
		list = usertable.getAllUsersForTableView();
		//create a forloop to add this data to the observable list
	    for(int i=0; i< list.size(); i++ ) {
	    		//add it to the list
	    		userData.add(list.get(i));
	    }


		for (ScreenUser screenUser : list) {
			screenUser.getComboBox().getSelectionModel().selectFirst();
		}
        
		

		TableColumn idCol = new TableColumn("UserID:");
		//set the editable property to false
		idCol.setEditable(false);
		//set the cellfactory to the email_id for screenUser
		idCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, Integer>("email_id"));
		//set the minimum width
		idCol.setMinWidth(65);
		//set the maximum width
		idCol.setMaxWidth(150);
		
		//create the callback for the columns
		Callback<TableColumn<ScreenUser, String>, TableCell<ScreenUser, String>> cellFactory = (
				TableColumn<ScreenUser, String> p) -> new EditCellAccountManagement();
		
		//create the email column for the table
		TableColumn<ScreenUser, String> emailCol = new TableColumn("Email:");
		//set the editable property to false
		emailCol.setEditable(true);
		//set the cellfactory to the email for screenUser
		emailCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("email"));
		//set the minimum width
		emailCol.setMinWidth(245);
		//set the cellfactory to the created one
		emailCol.setCellFactory(cellFactory);
		
		//create the fnameCol column for the table
		TableColumn<ScreenUser, String> fnameCol = new TableColumn("First name:");
		//set the editable property to false
		fnameCol.setEditable(true);
		//set the cellfactory to the fname for screenUser
		fnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("fname"));
		//set the minimum width
		fnameCol.setMinWidth(150);
		//set the cellfactory to the created one
		fnameCol.setCellFactory(cellFactory);
		
		//create the lnameCol column for the table
		TableColumn<ScreenUser, String> lnameCol = new TableColumn("Last name:");
		//set the editable property to false
		lnameCol.setEditable(true);
		//set the cellfactory to the lname for screenUser
		lnameCol.setCellValueFactory(new PropertyValueFactory<ScreenUser, String>("lname"));
		//set the minimum width
		lnameCol.setMinWidth(150);
		//set the cellfactory to the created one
		lnameCol.setCellFactory(cellFactory);
		

//		ObservableList<String> roles = FXCollections.observableArrayList(); 
//		roles.add("clerk");
//		roles.add("manager");
//		roles.add("administrator");
		
		//TableColumn<ScreenUser, String> comboCol = new TableColumn("Role:");
		TableColumn<ScreenUser, ComboBox<Position>> comboCol = new TableColumn("Role:");

		comboCol.setVisible(true);
		comboCol.setCellValueFactory(new PropertyValueFactory<ScreenUser,ComboBox<Position>>("comboBox"));
		//comboCol.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(),roles));

		//create the observableList for the desired roles the project has requested
//		ObservableList<String> roles = FXCollections.observableArrayList(); 
//		//add the clerk to the roles
//		roles.add("clerk");
//		//add manager to the roles
//		roles.add("manager");
//		//add administrator to the roles
//		roles.add("administrator");
		
//		//create the comboColumn for changing usernames
//		TableColumn<ScreenUser, String> comboCol = new TableColumn("Role:");
//		//set the visibility to true
//		comboCol.setVisible(true);
//		//set the cellfactory to the role for screenUser
//		comboCol.setCellValueFactory(new PropertyValueFactory<>("role"));
		//set the cellfactory observableList we created for the roles
		//comboCol.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(),roles));
		//set the minimum width for the minimum width

		comboCol.setMinWidth(230);
		//ComboBoxTableCell.forTableColumn(new DefaultStringConverter().roles)).
		
		//add the columns to the table
		table.getColumns().addAll(idCol, emailCol, fnameCol, lnameCol, comboCol);
		//set the items to the userdata field cast it to the columns
		table.setItems(userData);
		//set the maximum width to 1000
		table.setMaxWidth(1000);
		//set the columnresizepolicy to constrained
		table.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
		//table.setMinWidth(300);
		table.setMaxHeight(500);
		table.setStyle("-fx-font-size: 16;");
		/**
		 * create the onclick listieners for the editcell's
		 */
		//create a new user for the proposedchanges to that selected row
		User proposedChanges = new User();
		//create another user class to save the saveduser to the database
		User savedUser = new User();
	
		
		
		/**
		 * Create the on edit commit methods to grab the currently selected information from the tableview
		 */
		
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

//		
//		comboCol.setOnEditCommit((TableColumn.CellEditEvent<ScreenUser, String> t) -> {
//			ScreenUser cursor=(ScreenUser) t.getTableView().getItems().get(
//					t.getTablePosition().getRow());
//
//		}
		userRoleTable=new UserRoleTable();
		 
		table.setOnMouseClicked(e->{
			

			for(int i=0;i<userData.size();i++) {
				String positonStr=userData.get(i).getComboBox().getSelectionModel().getSelectedItem().getPosition();
				if(positonStr.equals("clerk")){
					userRoleTable.updateRole(1,userData.get(i).getEmail_id());
				} else if(positonStr.equals("manager")) {
						userRoleTable.updateRole(2,userData.get(i).getEmail_id());
					}
//					else if(positonStr.equals("administrator")) {
//						userRoleTable.updateRole(3,userData.get(i).getEmail_id());
//					}
			  
			}
			
		});
		

//		});
		
		
		//create the action button to save the information tot he database
		saveChanges.setOnAction(e->{

//			
//			System.out.println(savedUser.getEmail());
//			System.out.println(savedUser.getEmail_id());
//			System.out.println(savedUser.getFirstname());
//			System.out.println(savedUser.getLastname());
          

			
			
			//System.out.println(savedUser.getEmail());
			//System.out.println(savedUser.getEmail_id());
			//System.out.println(savedUser.getFirstname());
			//System.out.println(savedUser.getLastname());


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

		//set the center of the pane to the tableview
		pane.setCenter(table);
		
		//create the scene for this tage
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
				
				if(userRoleTable.getRoleId(loginUser.getEmail_id())!=3) {
					accountManagement.setVisible(false);
				}
				
				
				VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, statisticScreen, deleteStock,accountManagement);
						
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
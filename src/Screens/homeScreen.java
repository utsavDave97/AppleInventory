package Screens;

import java.util.ArrayList;

import JavaBean.Product;
import JavaBean.User;
import Tables.ProductTable;
import Tables.UserRoleTable;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author utsav
 *
 */

public class homeScreen 
{
	public homeScreen()
	{
		//create a stage
		Stage homeStage = new Stage();
		//create a borderpane
		BorderPane root = new BorderPane();
		//create a content
		VBox content = new VBox();
		//add the stylesheet to the borderpane
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		//create a new productTable
		ProductTable productTable = new ProductTable();
		
		//create a new list of products 
		ArrayList<Product> products = productTable.getAllProducts();
		
		//create a new tableview
		TableView table = new TableView();
		//set the tableview editble to false
		table.setEditable(false);
		//set the style of the table
		table.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 18");
		//create the appleNameColumn
		TableColumn appleNameColumn = new TableColumn("Apple Type");
		//create the applePriceColumn
		TableColumn applePriceColumn = new TableColumn("Price/Kilo");
		//create the appleTasteColumn
		TableColumn appleTasteColumn = new TableColumn("Taste");
		
		//create the appleNameColumn prefWidthProperty
		appleNameColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		//create the applePriceColumn prefWidthProperty
		applePriceColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		//create the appleTasteColumn prefWidthProperty
		appleTasteColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		
		//set the appleNameColumn cellvaluefactory
		appleNameColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_name"));
		//set the applePriceColumn cellvaluefactory
		applePriceColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_price"));
		//set the appleTasteColumn cellvaluefactory
		appleTasteColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_taste"));
		//set the items for the table
		table.setItems(FXCollections.observableArrayList(products));
		//set the columns for the table 
		table.getColumns().addAll(appleNameColumn,applePriceColumn,appleTasteColumn);
		
		
		//Color c = Color.web("#DCDCDC");
		root.setStyle("-fx-background-color: #DCDCDC;");
		
		//create the title label for the title
		Label title = new Label("Your Inventory:");
		//create the style for label for the title
		title.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 25;");
		//create the setPadding for label for the title
		title.setPadding(new Insets(0,0,25,10));
		
		//create the toggleButton navigationButton
		ToggleButton navigationButton = new ToggleButton();
		//create the ImageView menuImage
		ImageView menuImage = new ImageView("menu.png");
		//set the graphic for the imageview
		navigationButton.setGraphic(menuImage);
		
		//create the pane spacer
		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		//create the pane spacer2
		final Pane spacer2 = new Pane();
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		
		//create the imageview logOutImage
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);
		
		logOutButton.setOnAction(e->{
			new logInScreen();
			homeStage.close();
		});
		
		Label heading = new Label("AppleCore INC.");
		heading.setStyle("-fx-text-fill: #B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 30;");
		
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
				
		navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
	    });
	    
	    content.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				root.setLeft(null);
			}
	
		});
	    
	    newTransaction.setOnAction(e->{
	    	new newTransactionScreen();
	    	homeStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
	    	homeStage.close();
	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	homeStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	homeStage.close();
	    });
	    
	    accountManagement.setOnAction(e->{
	    	new accountManagementScreen();
	    	homeStage.close();
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	homeStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	new deleteStockScreen();
	    	homeStage.close();
	    });
	    
	    logOutButton.setOnAction(e->{
	    	new logInScreen();
	    	homeStage.close();
	    });
		
	    content.getChildren().addAll(title,table);
	    
	    root.setCenter(content);
		root.setTop(navigationToolBar);
		Scene scene = new Scene(root,1024,768);
		homeStage.setScene(scene);
		homeStage.show();
		
	}
}

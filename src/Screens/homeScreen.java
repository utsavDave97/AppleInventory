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
		Stage homeStage = new Stage();
		
		BorderPane root = new BorderPane();
		
		VBox content = new VBox();
				
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		ProductTable productTable = new ProductTable();
		
		ArrayList<Product> products = productTable.getAllProducts();
		
		TableView table = new TableView();
		table.setEditable(false);
		table.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 18");

		TableColumn appleNameColumn = new TableColumn("Apple Type");
		TableColumn applePriceColumn = new TableColumn("Price/Kilo");
		TableColumn appleTasteColumn = new TableColumn("Taste");
		
		appleNameColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		applePriceColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		appleTasteColumn.prefWidthProperty().bind(table.widthProperty().divide(3));
		
		appleNameColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_name"));
		
		applePriceColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_price"));
		
		appleTasteColumn.setCellValueFactory(
				new PropertyValueFactory<Product,String>("prod_taste"));
		
		table.setItems(FXCollections.observableArrayList(products));
		
		table.getColumns().addAll(appleNameColumn,applePriceColumn,appleTasteColumn);
		
		
		//Color c = Color.web("#DCDCDC");
		root.setStyle("-fx-background-color: #DCDCDC;");
		
		Label title = new Label("Your Inventory:");
		
		title.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 25;");
		
		title.setPadding(new Insets(0,0,25,10));
		
		ToggleButton navigationButton = new ToggleButton();
		ImageView menuImage = new ImageView("menu.png");
		navigationButton.setGraphic(menuImage);
		
		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		final Pane spacer2 = new Pane();
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		
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
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Completed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		Button accountManagement = new Button("Account Management");
		Button statisticScreen = new Button("Statistic Screen");

		//If the user is clerk role, who cann't visit accountManager functionality
		logInScreen login=new logInScreen();
		User loginUser=login.getUserInstance();
		UserRoleTable userRoleTable=new UserRoleTable();
		
		if(userRoleTable.getRoleId(loginUser.getEmail_id())==1) {
			accountManagement.setVisible(false);
			statisticScreen.setVisible(false);
		}else if(userRoleTable.getRoleId(loginUser.getEmail_id())==2){
			
			accountManagement.setVisible(false);
		}
		
		
		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock,  deleteStock,statisticScreen,accountManagement);
		
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

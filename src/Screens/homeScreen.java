package Screens;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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
				
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		//Color c = Color.web("#DCDCDC");
		root.setStyle("-fx-background-color: #DCDCDC;");
		
		ToggleButton navigationButton = new ToggleButton();
		ImageView menuImage = new ImageView("menu.png");
		navigationButton.setGraphic(menuImage);
		
		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);
		
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer,logOutButton);
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Completed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		Button accountManagement = new Button("Account Management");
		Button statisticScreen = new Button("Statistic Screen");

		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, accountManagement, statisticScreen, deleteStock);
		
		
	    navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
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
	    	
	    });
	    
	    logOutButton.setOnAction(e->{
	    	new logInScreen();
	    	homeStage.close();
	    });
		
		root.setTop(navigationToolBar);
		Scene scene = new Scene(root,1024,768);
		homeStage.setScene(scene);
		homeStage.show();
		
	}
}

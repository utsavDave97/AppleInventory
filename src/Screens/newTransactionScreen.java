package Screens;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Jianqin Wang
 * @Description This class is the first Screen for transaction.When click on New Transaction Button on
 *     Main menu, this class will be called.
 *
 */


public class newTransactionScreen {
	
	public newTransactionScreen() {
        //create the stage 
		 Stage transactionStage= new Stage();
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		//Create a gridpane layout to store content
//		GridPane trGridpane = new GridPane();
//		
//		trGridpane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
//		
//		//Create the horizontal gap between the elements in gridpane
//		trGridpane.setHgap(15);
//		//create the vertical gap between the elements in gridpane
//		trGridpane.setVgap(25);
//		//create the style for the gridpane background
//		trGridpane.setStyle("-fx-background-color:DCDCDC");	
//		trGridpane.setAlignment(Pos.CENTER);
		
		/************************************************************************************
		 *                  Navigation Bar
		 *************************************************************************************/
		ToggleButton navigationButton = new ToggleButton();
		ImageView menuImage = new ImageView("menu.png");
		navigationButton.setGraphic(menuImage);
		
		//Creating space between navigation button and log out button
		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		//Creating logOutButton and setting its image
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);
		
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer,logOutButton);
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Completed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		
		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, deleteStock);
	    
	    navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
	    });
	    
	    newTransaction.setOnAction(e->{
	    	new newTransactionScreen();
	    	transactionStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{

	   new completedTranScreen();
	    transactionStage.close();


	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	transactionStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	transactionStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	
	    	//transactionStage.close();
	    });
	    
	    
	    /****************************************************************************************************
	     * 	   Navigation Item 
	     **************************************************************************************************/
	    


	    currentranTab newTransactionPane=new currentranTab();
	    
	    
	    /****************************************************************************************************
	     * 	   set pane and Add the page to stage 
	     **************************************************************************************************/	    
	    
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(newTransactionPane);
	  //create the scene
		Scene scene = new Scene(root, 1024, 768);
		
		
		//show the stage
		transactionStage.setScene(scene);
		transactionStage.show();


  }

}

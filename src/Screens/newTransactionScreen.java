package Screens;
import JavaBean.User;
import Tables.UserRoleTable;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
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


public class newTransactionScreen 
{	
	public newTransactionScreen() 
	{
		//create the stage 
		Stage transactionStage= new Stage();

		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");

		/************************************************************************************
		 *                  Navigation Bar
		 *************************************************************************************/
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
			transactionStage.close();
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
	    
	    accountManagement.setOnAction(e->{
	    	new accountManagementScreen();
	    	transactionStage.close();
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	transactionStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	new deleteStockScreen();
	    	transactionStage.close();
	    });
	    
	    
	    /****************************************************************************************************
	     * 	   Navigation Item 
	     **************************************************************************************************/
	    


	    currentranTab newTransactionPane=new currentranTab();
	    
	    newTransactionPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				root.setLeft(null);
			}

		});
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

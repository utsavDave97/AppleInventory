package Screens;





import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @despription Display the completed sale items which can also be revised by user
 * @author wjqcau
 *
 */
public class completedTranScreen 
{
	
	public completedTranScreen() {
		/**********************************************************************
		 *                Basic Stage,Pane Definition                          *
		 ***********************************************************************/
        //create the stage 
		Stage comtransStage = new Stage();
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		

		
		/**********************************************************************
		 *                  Navigation Items                                   *
		 ***********************************************************************/
		
		
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
				
		//Creating toolBar and adding navigation button and logout button to it
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer,logOutButton);
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Competed Transaction");
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
	    	comtransStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
	    	comtransStage.close();
	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	comtransStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	comtransStage.close();
	    });
	    
	    accountManagement.setOnAction(e->{
	    	//add in the new screen launcher here
	    	//close the current stage here
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	comtransStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	
	    });
	    
	    logOutButton.setOnAction(e->{
	    	new logInScreen();
	    	comtransStage.close();
	    });
	    
		//create the content for the Completed transaction
		
		
	    /**********************************************************************
		 *                Table View Content                                  *
		 ***********************************************************************/    
	    TabPane compTransactionPane=new TabPane();
	    
	    Tab newComtrasancionTab=new Tab("Current Transaction");
	     
	    newComtrasancionTab.setStyle("-fx-font-size:16;");
	    newComtrasancionTab.setClosable(false);
	    newComtrasancionTab.setContent(new currentranTab());
	    Tab updateTransactionTab=new Tab("History Transaction");
	    updateTransactionTab.setClosable(false);
	    updateTransactionTab.setStyle("-fx-font-size:16;");
	    updateTransactionTab.setContent(new historyTranTab());
	    compTransactionPane.getTabs().addAll(newComtrasancionTab,updateTransactionTab);
	    root.setTop(navigationToolBar);
	    root.setCenter(compTransactionPane);
	    //root.setBottom(hbox);
	  //create the scene
		Scene scene = new Scene(root, 1024, 768);
		
		
		//show the stage
		comtransStage.setScene(scene);
		comtransStage.show();


  }
	 
   

}

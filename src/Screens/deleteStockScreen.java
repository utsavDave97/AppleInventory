package Screens;

import JavaBean.Product;
import JavaBean.Stock;
import Tables.ProductTable;
import Tables.StockTable;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class deleteStockScreen 
{
	
	public deleteStockScreen()
	{
		ProductTable productTable = new ProductTable();
		StockTable stockTable = new StockTable();
		
		Stage deleteStage = new Stage();
		
		//Create the root pane and give it styling
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		root.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		//Create the gridpane
		GridPane gridPane = new GridPane();
		
		//Create the horizontal gap between the elements in gridpane
		gridPane.setHgap(15);
		
		//create the vertical gap between the elements in gridpane
		gridPane.setVgap(25);
		
		//set alignment
		gridPane.setAlignment(Pos.CENTER);
		
		//Creating navigationButton and setting its image
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
			deleteStage.close();
		});
		
		Label heading = new Label("AppleCore INC.");
		heading.setStyle("-fx-text-fill: #B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 30;");
		
		//Creating toolBar and adding navigation button and logout button to it
		ToolBar navigationToolBar = new ToolBar(navigationButton,spacer2,heading,spacer,logOutButton);
		
		Button newTransaction = new Button("New Transaction");
		Button completedTransaction = new Button("Completed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		Button accountManagement = new Button("Account Management");
		Button statisticScreen = new Button("Statistic Screen");

		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, accountManagement, statisticScreen, deleteStock);
		
		Label selectLabel = new Label("Select Item to Delete:");
	    selectLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    
	    ComboBox<Product> selectProduct = new ComboBox<>();
	    selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
	    
	    selectProduct.getSelectionModel().select(0);
	    
	    selectProduct.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    selectProduct.setPrefSize(300, 30);
	    
	    //create the Submit button
  		Button submit = new Button("Submit");
  		//create the styling
  		submit.setStyle("-fx-border-color:B82F33;"
  					  + "-fx-font-family: Quicksand;"
  					  + "-fx-font-size: 12pt;");
  		
  		submit.setOnAction(e->{
  			
  			int prodID = selectProduct.getSelectionModel().getSelectedItem().getProd_Id();
  			
  			Stock stock = new Stock(prodID,0);
  			
  			stockTable.deleteStock(stock);
  			
  			Alert successInsert = new Alert(AlertType.INFORMATION);
	    	successInsert.setTitle("Successfully Deleted");
	    	successInsert.setHeaderText(null);
	    	successInsert.setContentText("Quantity has been set to 0.");
	    	successInsert.showAndWait();
  			
  			selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
  		});
	    
  		//Creating onClickListener on navigationButton
	    navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
	    });
	    
	    gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				root.setLeft(null);
			}
	
		});
	    
	    newTransaction.setOnAction(e->{
	    	new newTransactionScreen();
	    	deleteStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
	    	deleteStage.close();
	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	deleteStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	deleteStage.close();
	    });
	    
	    accountManagement.setOnAction(e->{
	    	new accountManagementScreen();
	    	deleteStage.close();
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	deleteStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	new deleteStockScreen();
	    	deleteStage.close();
	    });
	    
	    gridPane.add(selectLabel, 0, 0);
		gridPane.add(selectProduct, 1, 0, 3, 1);
		
		gridPane.add(submit, 0, 2);
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
	    deleteStage.setScene(scene);
	    deleteStage.show();
	}
	
}
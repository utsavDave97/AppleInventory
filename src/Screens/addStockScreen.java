/**
 * @author utsav
 */
package Screens;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import JavaBean.Product;
import JavaBean.Stock;
import JavaBean.User;
import Tables.ProductTable;
import Tables.StockTable;
import Tables.UserRoleTable;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class addStockScreen 
{
	//create a new product object
	Product product;
	
	public addStockScreen()
	{
		//create a new table object
		ProductTable table = new ProductTable();
		//create a new stocktable
		StockTable stockTable = new StockTable();
		
		
		//Create the Stage
		Stage addStockStage = new Stage();
		
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
		//set the menuimage to the desired picture
		ImageView menuImage = new ImageView("menu.png");
		//set the graphic to the menuimage
		navigationButton.setGraphic(menuImage);
		
		//Creating space between navigation button and log out button
		final Pane spacer = new Pane();
		//set the hgrow
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		//create a new pane
		final Pane spacer2 = new Pane();
		//set the hgrow
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		
		//Creating logOutButton and setting its image
		ImageView logOutImage = new ImageView("logout.png");
		//create a new togglebutton so we can log the user out
		ToggleButton logOutButton = new ToggleButton("Log Out");
		//set the graphic to the image
		logOutButton.setGraphic(logOutImage);
		
		//create the logoutbutton action button
		logOutButton.setOnAction(e->{
			new logInScreen();
			addStockStage.close();
		});
		
		Label heading = new Label("AppleCore INC.");
		heading.setStyle("-fx-text-fill: #B82F33;"
				+ "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 30;");
		
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
		
	    String textFieldStyle="-fx-focus-color: #00FFFFFF;"
							+ "-fx-font-size:15pt;"
							+ "-fx-min-height:35";
	    
	    
	    //Creating Type
	    Label typeLabel = new Label("Type:");
	    typeLabel.setStyle("-fx-font-family: Quicksand;"
	    				 + "-fx-font-size: 12pt;");
	    
	    TextField typeField = new TextField();
	    typeField.setStyle(textFieldStyle);
	    
	    //Creating Quantity
	    Label quantityLabel = new Label("Quantity:");
	    quantityLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");

		TextField quantityField = new TextField();
		quantityField.setStyle(textFieldStyle);
		
		//Creating Taste DropDown Menu
		Label tasteLabel = new Label("Taste:");
		tasteLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
		
		ObservableList<String> tasteList = FXCollections.<String>observableArrayList("Less Sweet", 
				"Medium Sweet", 
				"More Sweet");
		
		ComboBox tasteNames = new ComboBox(tasteList);
		tasteNames.getSelectionModel().selectFirst();
		tasteNames.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
		tasteNames.setPrefSize(300, 30);
		
		//Creating Price/Kilo
	    Label priceLabel = new Label("Price/Kilo:");
	    priceLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");

		TextField priceField = new TextField();
		priceField.setStyle(textFieldStyle);
		
		//Create Reset Button
		Button reset = new Button("Reset");
		//set the styling for the button
		reset.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
		
		//create the Submit button
		Button submit = new Button("Submit");
		//create the styling
		submit.setStyle("-fx-border-color:B82F33;"
					  + "-fx-font-family: Quicksand;"
					  + "-fx-font-size: 12pt;");
	    
		
		ComboBox<Product> selectProduct = new ComboBox<>();
	    selectProduct.setItems(FXCollections.observableArrayList(table.getAllProducts()));
		
		//Set contents to GridPane
		gridPane.add(typeLabel, 0, 0);
		gridPane.add(typeField, 1, 0, 3, 1);
	    
		gridPane.add(quantityLabel,0,1);
		gridPane.add(quantityField, 1, 1,3,1);
		
		gridPane.add(tasteLabel, 0, 2);
		gridPane.add(tasteNames, 1, 2,3,1);
		
		gridPane.add(priceLabel,0,3);
		gridPane.add(priceField, 1, 3,3,1);
	    
		gridPane.add(reset, 1, 5);
		gridPane.add(submit,3, 5);
		
		
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
	    	addStockStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
	    	addStockStage.close();
	    });
	    
	    accountManagement.setOnAction(e->{
	    	new accountManagementScreen();
	    	addStockStage.close();
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	addStockStage.close();
	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	addStockStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	addStockStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	new deleteStockScreen();
	    	addStockStage.close();
	    });
	    
	    reset.setOnAction(e->{
	    	typeField.clear();
	    	quantityField.clear();
	    	priceField.clear();
	    });
	    
	    submit.setOnAction(e->
	    {
	    	product = new Product(
	    			typeField.getText().trim(),
	    			priceField.getText().trim(),
	    			tasteNames.getSelectionModel().getSelectedItem().toString()
	    			);
	    	
	    	Stock stock = new Stock(
	    			product.getProd_Id(),
	    			Integer.parseInt(quantityField.getText())
	    			);
	    	
	    	table.createProduct(product);
	    	stockTable.createStock(stock);
	    	
	    	Alert successInsert = new Alert(AlertType.INFORMATION);
	    	successInsert.setTitle("Successful Insert");
	    	successInsert.setHeaderText(null);
	    	successInsert.setContentText("Record has been inserted!");
	    	successInsert.showAndWait();
	    	
	    	typeField.clear();
	    	quantityField.clear();
	    	priceField.clear();
	    });
	    
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
		addStockStage.setScene(scene);
		addStockStage.show();
	}
	
}

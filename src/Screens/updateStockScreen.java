/**
 * @author utsav
 */
package Screens;

import JavaBean.Product;
import JavaBean.Stock;
import Tables.ProductTable;
import Tables.StockTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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

public class updateStockScreen 
{
	Product product;
	Stock stock;
	
	public updateStockScreen()
	{
		ProductTable productTable = new ProductTable();
		StockTable stockTable = new StockTable();
		
		Stage updateStage = new Stage();
		
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
			updateStage.close();
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
		
	    //Creating default textField style
	    String textFieldStyle="-fx-focus-color: #00FFFFFF;"
				+ "-fx-font-size:15pt;"
				+ "-fx-min-height:35";
	    
	    String labelStyle = "-fx-font-family: Quicksand;"
	    				  + "-fx-font-size: 12pt;";
	    
	    
	    Label selectLabel = new Label("Select Item to Update:");
	    selectLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    
	    ComboBox<Product> selectProduct = new ComboBox<>();
	    selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
	    
	    selectProduct.getSelectionModel().select(0);
	    
	    selectProduct.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    selectProduct.setPrefSize(300, 30);
	    
	    Label stockQuantityLabel = new Label("Quantity:");
	    stockQuantityLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    
	    ComboBox<Stock> selectProductQuantity = new ComboBox<>();
	    selectProductQuantity.setItems(FXCollections.observableArrayList(stockTable.getAllStocks()));
	    selectProductQuantity.getSelectionModel().select(selectProduct.getSelectionModel().getSelectedIndex());
	    
	    selectProductQuantity.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
	    selectProductQuantity.setPrefSize(300, 30);
	    
		//Creating TypeField
		Label nameLabel = new Label("Change Name:");
		nameLabel.setStyle(labelStyle);
		
		TextField nameField = new TextField();
		nameField.setStyle(textFieldStyle);
		nameField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_name());
		
		//Creating Quantity
		Label quantityLabel = new Label("Change Quantity:");
		quantityLabel.setStyle(labelStyle);
		
		TextField quantityField = new TextField();
		quantityField.setStyle(textFieldStyle);
				
		
		//Creating Price/Kilo
		Label priceLabel = new Label("Change Price/Kilo:");
		priceLabel.setStyle(labelStyle);
		
		TextField priceField = new TextField();
		priceField.setStyle(textFieldStyle);
		priceField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_price());
		
		//Creating Price/Kilo
		Label tasteLabel = new Label("Change Taste:");
		tasteLabel.setStyle(labelStyle);
		
		ObservableList<String> tasteList = FXCollections.<String>observableArrayList("Less Sweet", 
				"Medium Sweet", 
				"More Sweet");
		
		ComboBox tasteNames = new ComboBox(tasteList);
		tasteNames.getSelectionModel().selectFirst();
		tasteNames.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
		tasteNames.setPrefSize(300, 30);
		
		//create the Submit button
		Button submit = new Button("Submit");
		//create the styling
		submit.setStyle("-fx-border-color:B82F33;"
					  + "-fx-font-family: Quicksand;"
					  + "-fx-font-size: 12pt;");
	    submit.setOnAction(e->
	    {
	    	int prodID = selectProduct.getSelectionModel().getSelectedItem().getProd_Id();
	    	
	    	System.out.println(prodID);
	    	
	    	product = new Product(prodID,
					nameField.getText(),
					priceField.getText(),
					tasteNames.getSelectionModel().getSelectedItem().toString());
	    	
	    	if(quantityField.getText().equals(""))
	    	{
	    		stock = new Stock(prodID,selectProductQuantity.getSelectionModel().getSelectedItem().getProd_qty());
	    	}
	    	else
	    	{
	    		stock = new Stock(prodID,
						 Integer.parseInt(quantityField.getText()));
	    	}
	    	
	    	stockTable.updateStock(stock);
	    	productTable.updateProduct(product);
	    	
	    	Alert successInsert = new Alert(AlertType.INFORMATION);
	    	successInsert.setTitle("Successfully Updated");
	    	successInsert.setHeaderText(null);
	    	successInsert.setContentText("Record has been updated!");
	    	successInsert.showAndWait();
	    	
	    	nameField.clear();
	    	quantityField.clear();
	    	priceField.clear();
	    	
	    	selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
	    	
	    });
		
		//Set content to GridPane
		gridPane.add(selectLabel, 0, 0);
		gridPane.add(selectProduct, 1, 0, 3, 1);
		
		gridPane.add(stockQuantityLabel,0 , 2);
		gridPane.add(selectProductQuantity,1 , 2);
	    
		gridPane.add(nameLabel, 0, 4);
		gridPane.add(nameField, 1, 4);
		
		gridPane.add(quantityLabel, 0, 6);
		gridPane.add(quantityField, 1, 6);
		
		gridPane.add(priceLabel, 0, 8);
		gridPane.add(priceField, 1, 8);
		
		gridPane.add(tasteLabel, 0, 10);
		gridPane.add(tasteNames, 1, 10);
		
		gridPane.add(submit,2, 12);
		
		
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
	    	updateStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
	    	updateStage.close();
	    });
	    
	    addStock.setOnAction(e->{
	    	new addStockScreen();
	    	updateStage.close();
	    });
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	updateStage.close();
	    });
	    
	    accountManagement.setOnAction(e->{
	    	new accountManagementScreen();
	    	updateStage.close();
	    });
	    
	    statisticScreen.setOnAction(e->{
	    	new statisticScreen();
	    	updateStage.close();
	    });
	    
	    deleteStock.setOnAction(e->{
	    	new deleteStockScreen();
	    	updateStage.close();
	    });
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
		updateStage.setScene(scene);
		updateStage.show();
	}

}

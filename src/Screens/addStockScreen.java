/**
 * @author utsav
 */
package Screens;

import JavaBean.Product;
import Tables.ProductTable;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	public addStockScreen()
	{
		ProductTable table = new ProductTable();
		
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
		Button completedTransaction = new Button("Completed Transaction");
		Button addStock = new Button("Add Stock");
		Button updateStock = new Button("Update Stock");
		Button deleteStock = new Button("Delete Stock");
		
		VBox menu = navigationBar.createNavigationBar(newTransaction, completedTransaction, addStock, updateStock, deleteStock);
		
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
	    
	    newTransaction.setOnAction(e->{
	    	new newTransactionScreen();
	    	addStockStage.close();
	    });
	    
	    completedTransaction.setOnAction(e->{
	    	new completedTranScreen();
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
	    	
	    });
	    
	    reset.setOnAction(e->{
	    	typeField.clear();
	    	quantityField.clear();
	    	priceField.clear();
	    });
	    
	    submit.setOnAction(e->{
	    	Product product = new Product(
	    			typeField.getText().trim(),
	    			priceField.getText().trim(),
	    			tasteNames.getSelectionModel().getSelectedItem().toString(),
	    			quantityField.getText().trim()
	    			);
	    	
	    	table.createProduct(product);
	    	
	    	Alert successInsert = new Alert(AlertType.INFORMATION);
	    	successInsert.setTitle("Successful Insert");
	    	successInsert.setHeaderText(null);
	    	successInsert.setContentText("Record has been inserted!");
	    	successInsert.showAndWait();
	    });
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
		addStockStage.setScene(scene);
		addStockStage.show();
	}
	
}

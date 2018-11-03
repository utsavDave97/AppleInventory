/**
 * @author utsav
 */
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class addStockScreen 
{
	
	public addStockScreen()
	{
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
		
		//Creating navigaitonDrawer VBox
		VBox menu = new VBox();
		menu.setId("menu");
	    menu.setSpacing(5);
	    menu.setPadding(new Insets(5,5,5,5));
	    
	    //Creating dropShadow effect for buttons in navigationDrawer
		DropShadow ds = new DropShadow();
		ds.setRadius(4);
		ds.setOffsetX(6);
		ds.setOffsetY(6);
		ds.setColor(Color.GREY);
	    
		//Creating newTransaction Button and styling it
	    Button newTransaction = new Button("New Transaction");
	    newTransaction.setEffect(ds);
	    newTransaction.setStyle("-fx-font-family: Quicksand;");
	    newTransaction.setOnMouseEntered(e->{
	    	newTransaction.setScaleX(1.1);
	    	newTransaction.setScaleY(1.1);
	    });
	    newTransaction.setOnMouseExited(e->{
	    	newTransaction.setScaleX(1);
	    	newTransaction.setScaleY(1);
	    });   
	    
	    //Creating completedTransaction Button and styling it
	    Button completedTransaction = new Button("Completed Transaction");
	    completedTransaction.setEffect(ds);
	    completedTransaction.setStyle("-fx-font-family: Quicksand;");
	    completedTransaction.setOnMouseEntered(e->{
	    	completedTransaction.setScaleX(1.1);
	    	completedTransaction.setScaleY(1.1);
	    });
	    completedTransaction.setOnMouseExited(e->{
	    	completedTransaction.setScaleX(1);
	    	completedTransaction.setScaleY(1);
	    }); 
	    
	    //Creating addStock Button and styling it
	    Button addStock = new Button("Add to Stock");
	    addStock.setEffect(ds);
	    addStock.setStyle("-fx-font-family: Quicksand;");
	    addStock.setOnMouseEntered(e->{
	    	addStock.setScaleX(1.1);
	    	addStock.setScaleY(1.1);
	    });
	    addStock.setOnMouseExited(e->{
	    	addStock.setScaleX(1);
	    	addStock.setScaleY(1);
	    }); 
	    
	    //Creating updateStock Button and styling it
	    Button updateStock = new Button("Update Stock");
	    updateStock.setEffect(ds);
	    updateStock.setStyle("-fx-font-family: Quicksand;");
	    updateStock.setOnMouseEntered(e->{
	    	updateStock.setScaleX(1.1);
	    	updateStock.setScaleY(1.1);
	    });
	    updateStock.setOnMouseExited(e->{
	    	updateStock.setScaleX(1);
	    	updateStock.setScaleY(1);
	    }); 
	    
	    //Creating deleteStock Button and styling it
	    Button deleteStock = new Button("Delete Stock");
	    deleteStock.setEffect(ds);
	    deleteStock.setStyle("-fx-font-family: Quicksand;");
	    deleteStock.setOnMouseEntered(e->{
	    	deleteStock.setScaleX(1.1);
	    	deleteStock.setScaleY(1.1);
	    });
	    deleteStock.setOnMouseExited(e->{
	    	deleteStock.setScaleX(1);
	    	deleteStock.setScaleY(1);
	    }); 
	    
	    //Adding all the buttons to navigationDrawer
	    menu.getChildren().addAll(newTransaction,
	    						  completedTransaction,
	    						  addStock,
	    						  updateStock,
	    						  deleteStock);

	    
	    //Styling navigationDrawer
	    menu.getStylesheets().add(getClass().getResource("progress.css").toExternalForm());
	    
	    //Creating translation effects on navigationDrawer
	    menu.setTranslateX(0);
	    TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), menu);
	    
	    menuTranslation.setFromX(0);
	    menuTranslation.setToX(-180);
	    
	    menu.setOnMouseEntered(evt -> {
	        menuTranslation.setRate(-1);
	        menuTranslation.play();
	    });
	    menu.setOnMouseExited(evt -> {
	        menuTranslation.setRate(1);
	        menuTranslation.play();
	    });
	    
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
	    
	    updateStock.setOnAction(e->{
	    	new updateStockScreen();
	    	addStockStage.close();
	    });
	    
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
		addStockStage.setScene(scene);
		addStockStage.show();
	}
	
}

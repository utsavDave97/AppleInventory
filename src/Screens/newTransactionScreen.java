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
		Stage transactionStage = new Stage();
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		
		//Create a gridpane layout to store content
		GridPane trGridpane = new GridPane();
		
		trGridpane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		
		//Create the horizontal gap between the elements in gridpane
		trGridpane.setHgap(15);
		//create the vertical gap between the elements in gridpane
		trGridpane.setVgap(25);
		//create the style for the gridpane background
		trGridpane.setStyle("-fx-background-color:DCDCDC");	
		trGridpane.setAlignment(Pos.CENTER);
		
		
		ToggleButton navigationButton = new ToggleButton();
		ImageView menuImage = new ImageView("menu.png");
		navigationButton.setGraphic(menuImage);
		
		ToolBar navigationToolBar = new ToolBar(navigationButton);
		
		
		
		VBox menu = new VBox();
		menu.setId("menu");
	    menu.setSpacing(5);
	    menu.setPadding(new Insets(5,5,5,5));
	    
		DropShadow ds = new DropShadow();
		ds.setRadius(4);
		ds.setOffsetX(6);
		ds.setOffsetY(6);
		ds.setColor(Color.GREY);
		
		Button newTransaction = new Button("New Transaction");
	    newTransaction.setEffect(ds);
	    newTransaction.setStyle("-fx-font-family: Quicksand;"
	    		+ "-fx-pref-height: 80;" + 
	    		"    -fx-pref-width: 200;" + 
	    		"    -fx-border-width: 3 3 3 3;" + 
	    		"    -fx-background-color: #B8B8B8;" + 
	    		"    -fx-font-size: 15;");
	    newTransaction.setOnMouseEntered(e->{
	    	newTransaction.setScaleX(1.1);
	    	newTransaction.setScaleY(1.1);
	    	newTransaction.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;"
		    		+ "-fx-border-color: #B82F33;" + 
		    		"    -fx-border-width: 3 3 3 3;");
	    });
	    newTransaction.setOnMouseExited(e->{
	    	newTransaction.setScaleX(1);
	    	newTransaction.setScaleY(1);
	    	newTransaction.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;");
	    });   
	    
	    Button completedTransaction = new Button("Completed Transaction");
	    completedTransaction.setEffect(ds);
	    completedTransaction.setStyle("-fx-font-family: Quicksand;"
	    		+ "-fx-pref-height: 80;" + 
	    		"    -fx-pref-width: 200;" + 
	    		"    -fx-border-width: 3 3 3 3;" + 
	    		"    -fx-background-color: #B8B8B8;" + 
	    		"    -fx-font-size: 15;");
	    completedTransaction.setOnMouseEntered(e->{
	    	completedTransaction.setScaleX(1.1);
	    	completedTransaction.setScaleY(1.1);
	    	completedTransaction.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;"
		    		+ "-fx-border-color: #B82F33;" + 
		    		"    -fx-border-width: 3 3 3 3;");
	    });
	    completedTransaction.setOnMouseExited(e->{
	    	completedTransaction.setScaleX(1);
	    	completedTransaction.setScaleY(1);
	    	completedTransaction.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;");
	    }); 
	    
	    Button addStock = new Button("Add to Stock");
	    addStock.setEffect(ds);
	    addStock.setStyle("-fx-font-family: Quicksand;"
	    		+ "-fx-pref-height: 80;" + 
	    		"    -fx-pref-width: 200;" + 
	    		"    -fx-border-width: 3 3 3 3;" + 
	    		"    -fx-background-color: #B8B8B8;" + 
	    		"    -fx-font-size: 15;");
	    addStock.setOnMouseEntered(e->{
	    	addStock.setScaleX(1.1);
	    	addStock.setScaleY(1.1);
	    	addStock.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;"
		    		+ "-fx-border-color: #B82F33;" + 
		    		"    -fx-border-width: 3 3 3 3;");
	    });
	    addStock.setOnMouseExited(e->{
	    	addStock.setScaleX(1);
	    	addStock.setScaleY(1);
	    	addStock.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;");
	    }); 
	    
	    Button updateStock = new Button("Update Stock");
	    updateStock.setEffect(ds);
	    updateStock.setStyle("-fx-font-family: Quicksand;"
	    				+ "-fx-pref-height: 80;" + 
	    				"    -fx-pref-width: 200;" + 
	    				"    -fx-border-width: 3 3 3 3;" + 
	    				"    -fx-background-color: #B8B8B8;" + 
	    				"    -fx-font-size: 15;");
	    updateStock.setOnMouseEntered(e->{
	    	updateStock.setScaleX(1.1);
	    	updateStock.setScaleY(1.1);
	    	updateStock.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;"
		    		+ "-fx-border-color: #B82F33;" + 
		    		"    -fx-border-width: 3 3 3 3;");
	    });
	    updateStock.setOnMouseExited(e->{
	    	updateStock.setScaleX(1);
	    	updateStock.setScaleY(1);
	    	updateStock.setStyle("-fx-font-family: Quicksand;"
    				+ "-fx-pref-height: 80;" + 
    				"    -fx-pref-width: 200;" + 
    				"    -fx-border-width: 3 3 3 3;" + 
    				"    -fx-background-color: #B8B8B8;" + 
    				"    -fx-font-size: 15;");
	    }); 
	    
	    Button deleteStock = new Button("Delete Stock");
	    deleteStock.setEffect(ds);
	    deleteStock.setStyle("-fx-font-family: Quicksand;"
	    		+ "-fx-pref-height: 80;" + 
	    		"    -fx-pref-width: 200;" + 
	    		"    -fx-border-width: 3 3 3 3;" + 
	    		"    -fx-background-color: #B8B8B8;" + 
	    		"    -fx-font-size: 15;");
	    deleteStock.setOnMouseEntered(e->{
	    	deleteStock.setScaleX(1.1);
	    	deleteStock.setScaleY(1.1);
	    	deleteStock.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;"
		    		+ "-fx-border-color: #B82F33;" + 
		    		"    -fx-border-width: 3 3 3 3;");
	    });
	    deleteStock.setOnMouseExited(e->{
	    	deleteStock.setScaleX(1);
	    	deleteStock.setScaleY(1);
	    	deleteStock.setStyle("-fx-font-family: Quicksand;"
		    		+ "-fx-pref-height: 80;" + 
		    		"    -fx-pref-width: 200;" + 
		    		"    -fx-border-width: 3 3 3 3;" + 
		    		"    -fx-background-color: #B8B8B8;" + 
		    		"    -fx-font-size: 15;");
	    }); 
	    
	    menu.getChildren().addAll(newTransaction,
	    						  completedTransaction,
	    						  addStock,
	    						  updateStock,
	    						  deleteStock);

	    
	    //menu.getStylesheets().add(getClass().getResource("progress.css").toExternalForm());
	    menu.setStyle("-fx-background-color: #DCDCDC;");
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
	    
	    
	    navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
	    });
	    
		//create the content for the trgridpane & create the styling
		//Define a label font
		Font labelFont=new Font(18);
		//Define textField css style
		String textFieldStyle="-fx-focus-color: #00FFFFFF;"
				+ "-fx-font-size:15pt;"
				+ "-fx-min-height:35";
		 //add label for name
	    Label nameLabel=new Label("Type:");
	    //set the name font
	     nameLabel.setStyle("-fx-font-family: Quicksand;"
	     				  + "-fx-font-size: 12pt;");
		// Create the ObservableLists for the ComboBox
		ObservableList<String> appleList = FXCollections.<String>observableArrayList("Fuji", 
				"Gala", 
				"Red Delicious", 
				"Granny Smith",
				"Honeycrisp",
				"Golden Delicious",
				"Pink Lady",
				"Opal",
				"Jazz");
	    // Create the ListView for the seasons
	    ComboBox appleNames = new ComboBox(appleList);
	    //Give the first default selection item
	    appleNames.getSelectionModel().selectFirst();
	    //Set List Style Font
	    appleNames.setStyle(" -fx-font-family: Quicksand;"
	    				  + "-fx-font-size: 12pt;");
	    // Set the Size of the ComoBox
	    appleNames.setPrefSize(300, 30);
	    //create upc label
	    Label upcLabel=new Label("UPC Number:");
		 //set the label font
	    upcLabel.setStyle("-fx-font-family: Quicksand;"
	    				+ "-fx-font-size: 12pt;");
	    //Create TextField for product UPC number
	   	TextField UPCNumber = new TextField();
	   	 //set editable=false
	   	UPCNumber.setEditable(false);
		//create the styling for the textfield
		UPCNumber.setStyle(textFieldStyle);	
		//create a label for quantity
	    Label quantityLabel=new Label("Quantity(kilos):");
		 //set the name font
	     quantityLabel.setStyle("-fx-font-family: Quicksand;"
	     					  + "-fx-font-size: 12pt;");
		//Create TextField for product quantity
	   	TextField quantity = new TextField();
		//create the styling for the textfield
		quantity.setStyle(textFieldStyle);				
		
		//create price label
	    Label priceLabel=new Label("Price/kilo:");
		//set the label font
	    priceLabel.setStyle("-fx-font-family: Quicksand;"
	    				  + "-fx-font-size: 12pt;");
	    //Create TextField for product price
	   	TextField price = new TextField();
	   	 //set editable=false
	   	price.setEditable(false);
		//create the styling for the textfield
		price.setStyle(textFieldStyle);	
		
		
		//Create label for subtotal
		Label subtotalLabel=new Label("Subtotal:");
		//set the font 
		subtotalLabel.setStyle("-fx-font-family: Quicksand;"
							 + "-fx-font-size: 12pt;");
		//Create TextField for product quantity
	   	TextField subtotal = new TextField();
	   	//set editable=false
	   	subtotal.setEditable(false);
		//create the styling for the textfield
		subtotal.setStyle(textFieldStyle);
		//create the reset button
		Button reset = new Button("Reset");
		//set the styling for the button
		reset.setStyle("-fx-border-color: B82F33;"
					 + "-fx-font-family: Quicksand;"
					 + "-fx-font-size: 12pt;");
		//create the submit button
		Button submit = new Button("Submit");
		//create the register styling
		submit.setStyle("-fx-border-color:B82F33;"
					  + "-fx-font-family: Quicksand;"
					  + "-fx-font-size: 12pt;");
						
		
		
	    //Set content to GridPane
		trGridpane.add(nameLabel, 0, 0);
	    trGridpane.add(appleNames, 1, 0, 3, 1);
	    
	    trGridpane.add(upcLabel, 0, 1);
	    trGridpane.add(UPCNumber, 1, 1,3,1);
	    
	    trGridpane.add(quantityLabel,0,2);
	    trGridpane.add(quantity, 1, 2,3,1);
	    
	    trGridpane.add(priceLabel, 0, 3);
	    trGridpane.add(price, 1, 3,3,1);
	    
	    trGridpane.add(subtotalLabel, 0, 4);
	    trGridpane.add(subtotal, 1, 4,3,1);
	    
	    trGridpane.add(reset, 1, 5);
	    trGridpane.add(submit,3, 5);
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(trGridpane);
	  //create the scene
		Scene scene = new Scene(root, 1024, 768);
		
		
		//show the stage
		transactionStage.setScene(scene);
		transactionStage.show();


  }

}

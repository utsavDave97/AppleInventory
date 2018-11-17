/**
 * @author utsav
 */

package Screens;

import JavaBean.Product;
import Tables.ProductTable;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
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

public class updateStockScreen 
{
	public updateStockScreen()
	{
		ProductTable table = new ProductTable();
		
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
	    
	    //Creating default textField style
	    String textFieldStyle="-fx-focus-color: #00FFFFFF;"
				+ "-fx-font-size:15pt;"
				+ "-fx-min-height:35";
	    
	    String labelStyle = "-fx-font-family: Quicksand;"
	    				  + "-fx-font-size: 12pt;";
	    
	   //Creating Type DropDown Menu
		Label typeLabel = new Label("Type:");
		typeLabel.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
		
		ObservableList<String> typeList = FXCollections.<String>observableArrayList("Fuji", 
				"Gala", 
				"Red Delicious",
				"Granny Smith",
				"Honeycrisp",
				"Golden Delicious",
				"Pink Lady",
				"Opal",
				"Jazz");
		
		ComboBox typeNames = new ComboBox(typeList);
		typeNames.getSelectionModel().selectFirst();
		typeNames.setStyle("-fx-font-family: Quicksand;"
				 + "-fx-font-size: 12pt;");
		typeNames.setPrefSize(300, 30);
	    
		//Creating TypeField
		Label changeTypeLabel = new Label("Do you want to change type's name?");
		changeTypeLabel.setStyle(labelStyle);
		
		ToggleGroup changeTypeGroup = new ToggleGroup();
		
		RadioButton changeTypeYes = new RadioButton("Yes");
		changeTypeYes.setStyle(labelStyle);
		
		RadioButton changeTypeNo = new RadioButton("No");
		changeTypeNo.setStyle(labelStyle);
		changeTypeNo.setSelected(true);
		
		changeTypeYes.setToggleGroup(changeTypeGroup);
		changeTypeNo.setToggleGroup(changeTypeGroup);
		
		Label nameLabel = new Label("Type Name:");
		nameLabel.setStyle(labelStyle);
		
		TextField nameField = new TextField();
		nameField.setStyle(textFieldStyle);
		nameField.setEditable(false);
		
		changeTypeYes.setOnAction(e->{
			nameField.setEditable(true);
		});
		changeTypeNo.setOnAction(e->{
			nameField.setEditable(false);
		});
		
		//Creating Quantity
		Label changeQuantityLabel = new Label("Do you want to change quantity?");
		changeQuantityLabel.setStyle(labelStyle);
		
		ToggleGroup changeQuantiyGroup = new ToggleGroup();
		
		RadioButton changeQuantityYes = new RadioButton("Yes");
		changeQuantityYes.setStyle(labelStyle);
		
		RadioButton changeQuantityNo = new RadioButton("No");
		changeQuantityNo.setStyle(labelStyle);
		changeQuantityNo.setSelected(true);
		
		changeQuantityYes.setToggleGroup(changeQuantiyGroup);
		changeQuantityNo.setToggleGroup(changeQuantiyGroup);
		
		Label quantityLabel = new Label("Type Quantity:");
		quantityLabel.setStyle(labelStyle);
		
		TextField quantityField = new TextField();
		quantityField.setStyle(textFieldStyle);
		quantityField.setEditable(false);
		
		changeQuantityYes.setOnAction(e->{
			quantityField.setEditable(true);
		});
		changeQuantityNo.setOnAction(e->{
			quantityField.setEditable(false);
		});
				
		//Creating Price/Kilo
		Label changePriceLabel = new Label("Do you want to change price/kilo?");
		changePriceLabel.setStyle(labelStyle);
		
		ToggleGroup changePriceGroup = new ToggleGroup();
		
		RadioButton changePriceYes = new RadioButton("Yes");
		changePriceYes.setStyle(labelStyle);
		
		RadioButton changePriceNo = new RadioButton("No");
		changePriceNo.setStyle(labelStyle);
		changePriceNo.setSelected(true);
		
		changePriceYes.setToggleGroup(changePriceGroup);
		changePriceNo.setToggleGroup(changePriceGroup);
		
		Label priceLabel = new Label("Type Price/Kilo:");
		priceLabel.setStyle(labelStyle);
		
		TextField priceField = new TextField();
		priceField.setStyle(textFieldStyle);
		priceField.setEditable(false);
		
		changePriceYes.setOnAction(e->{
			priceField.setEditable(true);
		});
		changePriceNo.setOnAction(e->{
			priceField.setEditable(false);
		});
		
		
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
		
		reset.setOnAction(e->{
	    	nameField.clear();
	    	quantityField.clear();
	    	priceField.clear();
	    });
	    
	    submit.setOnAction(e->{
//	    	Product product = new Product(
//	    			nameField.getText().trim(),
//	    			quantityField.getText().trim(),
//	    			priceField.getText().trim()
//	    			);
//	    	
//	    	table.createProduct(product);
	    	
	    	Alert successInsert = new Alert(AlertType.INFORMATION);
	    	successInsert.setTitle("Successful Insert");
	    	successInsert.setHeaderText(null);
	    	successInsert.setContentText("Record has been inserted!");
	    	successInsert.showAndWait();
	    });
		
		//Set content to GridPane
		gridPane.add(typeLabel, 0, 0);
		gridPane.add(typeNames, 1, 0, 3, 1);
	    
		gridPane.add(changeTypeLabel,0,1);
		gridPane.add(changeTypeYes, 1, 1,3,1);
		gridPane.add(changeTypeNo, 3, 1,3,1);
		gridPane.add(nameLabel, 0, 2);
		gridPane.add(nameField, 1, 2);
		
		gridPane.add(changeQuantityLabel,0,3);
		gridPane.add(changeQuantityYes, 1, 3,3,1);
		gridPane.add(changeQuantityNo, 3, 3,3,1);
		gridPane.add(quantityLabel, 0, 4);
		gridPane.add(quantityField, 1, 4);
		
		gridPane.add(changePriceLabel,0,5);
		gridPane.add(changePriceYes, 1, 5,3,1);
		gridPane.add(changePriceNo, 3, 5,3,1);
		gridPane.add(priceLabel, 0, 6);
		gridPane.add(priceField, 1, 6);
		
		gridPane.add(reset, 1, 8);
		gridPane.add(submit,2, 8);
		
		
	    //Creating onClickListener on navigationButton
	    navigationButton.setOnAction(e->{
	    	root.setLeft(menu);
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
	    
	    deleteStock.setOnAction(e->{
	    	
	    });
	    
	    
	    root.setTop(navigationToolBar);
	    root.setCenter(gridPane);
	    Scene scene = new Scene(root,1024,768);
		updateStage.setScene(scene);
		updateStage.show();
	}

}

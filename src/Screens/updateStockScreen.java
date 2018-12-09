/**
 * @author utsav
 */
package Screens;

import JavaBean.Product;
import JavaBean.Stock;
import JavaBean.User;
import Tables.ProductTable;
import Tables.StockTable;
import Tables.UserRoleTable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	ComboBox<Product> selectProduct;
	public updateStockScreen()
	{
		//create an productTable so we can reference this later
		ProductTable productTable = new ProductTable();
		//create an stockTable so we can reference this later
		StockTable stockTable = new StockTable();

		//create an updateStage so we can reference this later
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
				
		//Creating default textField style
		String textFieldStyle="-fx-focus-color: #00FFFFFF;"
				+ "-fx-font-size:15pt;"
				+ "-fx-min-height:35";

		String labelStyle = "-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;";


		Label selectLabel = new Label("Select Item to Update:");
		selectLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		selectProduct = new ComboBox<>();
		selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
		selectProduct.getSelectionModel().selectFirst();

		selectProduct.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");
		selectProduct.setPrefSize(300, 30);

		Label stockQuantityLabel = new Label("Quantity:");
		stockQuantityLabel.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-font-size: 12pt;");

		ComboBox<Stock> selectProductQuantity = new ComboBox<>();
		selectProductQuantity.setItems(FXCollections.observableArrayList(stockTable.getAllStocks()));
		selectProductQuantity.getSelectionModel().select(selectProduct.getSelectionModel().getSelectedItem().getProd_Id());

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
		//priceField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_price());

		//Creating Taste
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


		selectProduct.valueProperty().addListener(new ChangeListener<Product>()
		{
			@Override
			public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
				// TODO Auto-generated method stub
				nameField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_name());
				quantityField.setText(String.valueOf(stockTable.getStock(selectProduct.getSelectionModel().getSelectedItem().getProd_Id())));
				priceField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_price());
				tasteNames.setValue(selectProduct.getSelectionModel().getSelectedItem().getProd_taste());
			}
		});

		submit.setOnAction(e->
		{
			int prodID = selectProduct.getSelectionModel().getSelectedItem().getProd_Id();

			System.out.println(prodID);

			product = new Product(prodID,
					nameField.getText(),
					priceField.getText(),
					tasteNames.getSelectionModel().getSelectedItem().toString());

			stock = new Stock(prodID,
					Integer.parseInt(quantityField.getText()));

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

			gridPane.getChildren().remove(selectProduct);
			selectProduct = new ComboBox<>();
			selectProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));
			selectProduct.getSelectionModel().selectFirst();
			selectProduct.setStyle("-fx-font-family: Quicksand;"
					+ "-fx-font-size: 12pt;");
			selectProduct.setPrefSize(300, 30);
			gridPane.add(selectProduct, 1, 0, 3, 1);
			selectProduct.valueProperty().addListener(new ChangeListener<Product>()
		{
			@Override
			public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
				// TODO Auto-generated method stub
				nameField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_name());
				quantityField.setText(String.valueOf(stockTable.getStock(selectProduct.getSelectionModel().getSelectedItem().getProd_Id())));
				priceField.setText(selectProduct.getSelectionModel().getSelectedItem().getProd_price());
				tasteNames.setValue(selectProduct.getSelectionModel().getSelectedItem().getProd_taste());
			}
		});

		});

		//Set content to GridPane
		gridPane.add(selectLabel, 0, 0);
		gridPane.add(selectProduct, 1, 0, 3, 1);

		gridPane.add(nameLabel, 0, 2);
		gridPane.add(nameField, 1, 2);

		gridPane.add(quantityLabel, 0, 4);
		gridPane.add(quantityField, 1, 4);

		gridPane.add(priceLabel, 0, 6);
		gridPane.add(priceField, 1, 6);

		gridPane.add(tasteLabel, 0, 8);
		gridPane.add(tasteNames, 1, 8);

		gridPane.add(submit,2, 10);


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

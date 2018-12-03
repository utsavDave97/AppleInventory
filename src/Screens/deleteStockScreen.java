package Screens;

import JavaBean.Product;
import JavaBean.Stock;
import JavaBean.User;
import Tables.ProductTable;
import Tables.StockTable;
import Tables.UserRoleTable;
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
		//create an productTable so we can reference this later
		ProductTable productTable = new ProductTable();
		//create an stockTable so we can reference this later
		StockTable stockTable = new StockTable();
		//create an deleteStage so we can reference this later
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
					//create the label for selectLabel
		Label selectLabel = new Label("Select Item to Delete:");
		//set the style of the selectLabel
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
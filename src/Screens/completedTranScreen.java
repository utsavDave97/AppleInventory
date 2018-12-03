package Screens;





import JavaBean.User;
import Tables.UserRoleTable;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
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

		final Pane spacer2 = new Pane();
		HBox.setHgrow(spacer2, Priority.ALWAYS);

		//Creating logOutButton and setting its image
		ImageView logOutImage = new ImageView("logout.png");
		ToggleButton logOutButton = new ToggleButton("Log Out");
		logOutButton.setGraphic(logOutImage);

		logOutButton.setOnAction(e->{
			new logInScreen();
			comtransStage.close();
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
			new accountManagementScreen();
			comtransStage.close();
		});

		statisticScreen.setOnAction(e->{
			new statisticScreen();
			comtransStage.close();
		});

		deleteStock.setOnAction(e->{
			new deleteStockScreen();
			comtransStage.close();
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

		compTransactionPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				root.setLeft(null);
			}

		});

		Tab newComtrasancionTab=new Tab("Search Transaction");

		newComtrasancionTab.setStyle("-fx-font-size:16;");
		newComtrasancionTab.setClosable(false);
		newComtrasancionTab.setContent(new searchTranTab());
		Tab updateTransactionTab=new Tab("Delete Transaction");
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

package Screens;





import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class completedTranScreen {
	
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
	    
		//create the content for the Completed transaction
		
		
	    /**********************************************************************
		 *                Table View Content                                  *
		 ***********************************************************************/    
	    TabPane compTransactionPane=new TabPane();
	    
	    Tab newComtrasancionTab=new Tab("Current Transaction");
	     
	    newComtrasancionTab.setStyle("-fx-font-size:16;");
	    newComtrasancionTab.setClosable(false);
	    newComtrasancionTab.setContent(new currentranTab());
	    Tab updateTransactionTab=new Tab("History Transaction");
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
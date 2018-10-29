package Screens;



import com.sun.jndi.toolkit.ctx.StringHeadTail;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
				//Create a gridpane layout to store content
				GridPane trGridpane = new GridPane();
				//Create the horizontal gap between the elements in gridpane
				trGridpane.setHgap(15);
				//create the vertical gap between the elements in gridpane
				trGridpane.setVgap(25);
				//create the style for the gridpane background
				trGridpane.setStyle("-fx-background-color:DCDCDC");	
				trGridpane.setAlignment(Pos.CENTER);
				
				
				
				//create the content for the trgridpane & create the styling
				//Define a label font
				Font labelFont=new Font(18);
				//Define textField css style
				String textFieldStyle="-fx-focus-color: #00FFFFFF;"
						+ "-fx-font-size:15pt;"
						+ "-fx-min-height:35";
				 //add label for name
			    Label nameLabel=new Label("Name:");
			    //set the name font
			     nameLabel.setFont(labelFont);
				// Create the ObservableLists for the ComboBox
				ObservableList<String> appleList = FXCollections.<String>observableArrayList("Fuji", "Banana", "Red Banana", "Sweet");
			    // Create the ListView for the seasons
			    ComboBox appleNames = new ComboBox(appleList);
			    //Give the first default selection item
			    appleNames.getSelectionModel().selectFirst();
			    //Set List Style Font
			    appleNames.setStyle(" -fx-font-size : 12pt;");
			    // Set the Size of the ComoBox
			    appleNames.setPrefSize(300, 30);
			    //create upc label
			    Label upcLabel=new Label("UPC Number:");
				 //set the label font
			    upcLabel.setFont(labelFont);
			    //Create TextField for product UPC number
			   	TextField UPCNumber = new TextField();
			   	 //set editable=false
			   	UPCNumber.setEditable(false);
				//create the styling for the textfield
				UPCNumber.setStyle(textFieldStyle);	
				//create a label for quantity
			    Label quantityLabel=new Label("Quantity(ponds):");
				 //set the name font
			     quantityLabel.setFont(labelFont);
				//Create TextField for product quantity
			   	TextField quantity = new TextField();
				//create the styling for the textfield
				quantity.setStyle(textFieldStyle);				
				
				//create price label
			    Label priceLabel=new Label("Price/pond:");
				//set the label font
			    priceLabel.setFont(labelFont);
			    //Create TextField for product price
			   	TextField price = new TextField();
			   	 //set editable=false
			   	price.setEditable(false);
				//create the styling for the textfield
				price.setStyle(textFieldStyle);	
				
				
				//Create label for subtotal
				Label subtotalLabel=new Label("Subtotal:");
				//set the font 
				subtotalLabel.setFont(labelFont);
				//Create TextField for product quantity
			   	TextField subtotal = new TextField();
			   	//set editable=false
			   	subtotal.setEditable(false);
				//create the styling for the textfield
				subtotal.setStyle(textFieldStyle);
				//create the login button
				Button reset = new Button("Reset");
				//set the styling for the button
				reset.setStyle("-fx-border-color: B82F33");
				//create the register button
				Button submit = new Button("Submit");
				//create the register styling
				submit.setStyle("-fx-border-color:B82F33");
								
				
				
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
			    
			    
			  //create the scene
				Scene scene = new Scene(trGridpane, 1064, 762);
				
				
				//show the stage
				transactionStage.setScene(scene);
				transactionStage.show();
		
		
	}
}

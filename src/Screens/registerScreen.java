package Screens;

import javax.swing.JComboBox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class registerScreen{

public registerScreen(){
	
	
			//create the stage to hold the content
			Stage stage = new Stage();
			//create the borderPane to hold the information
			BorderPane borderpane = new BorderPane();
			borderpane.setStyle("-fx-background-color: DCDCDC");
			borderpane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
			//create the gridpane to hold the information
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setHgap(5);
			pane.setVgap(5);
			
			//create the content for the gridpane
			//create the list for the combo box
			String[] comboContent = {"Clerk","Manager","Store-Owner"};
			//create the label for the first name
			Label fnameLabel = new Label("First Name:");
			fnameLabel.setStyle("-fx-font-family: Quicksand");
			//create the textfield for the first name
			TextField fname = new TextField();
			//create a label for the lastname
			Label lnameLabel = new Label("Last Name:");
			lnameLabel.setStyle("-fx-font-family: Quicksand");
			//create a textfield for the last name
			TextField lname = new TextField();
			//create a label for the username
			Label userNameLabel = new Label("User Name:");
			userNameLabel.setStyle("-fx-font-family: Quicksand");
			//create a textfied for the username
			TextField userName = new TextField();
			//create a label for the position
			Label positionLabel = new Label("Position:");
			positionLabel.setStyle("-fx-font-family: Quicksand");
			//create a combo box to store the position's
			ComboBox combo = new ComboBox();
			combo.setStyle("-fx-font-family: Quicksand");
			combo.getItems().addAll("Clerk","Manager");
			combo.getSelectionModel().select(0);
			//create a label for the password
			Label passwordLabel = new Label("Password:");
			passwordLabel.setStyle("-fx-font-family: Quicksand");
			//create a passwordfield for the password
			PasswordField passWord = new PasswordField();
			//create a button to reigster the user
			Button register = new Button("Register");
			register.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand; -fx-font-size: 12pt");
			Button clearInfo = new Button("Clear");
			clearInfo.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand;-fx-font-size: 12pt");
			//add the content to the gridpane
			pane.add(fnameLabel, 0, 0);
			pane.add(fname, 1, 0,3,1);
			
			pane.add(lnameLabel, 0, 1);
			pane.add(lname, 1, 1,3,1);
			
			pane.add(userNameLabel, 0, 2);
			pane.add(userName, 1, 2,3,1);
			
			pane.add(positionLabel, 0, 3);
			pane.add(combo, 1, 3,3,1);
			
			pane.add(passwordLabel, 0, 4);
			pane.add(passWord, 1, 4,3,1);
			
			pane.add(clearInfo, 0, 6);
			pane.add(register, 3, 6);
			
			borderpane.setCenter(pane);

			Scene scene = new Scene(borderpane,1064,762);
			stage.setScene(scene);
			stage.show();
	}

}

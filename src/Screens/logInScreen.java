package Screens;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Jonathan Stevanka
 * @description This class will be launched right after the launchscreen class is launched.
 */

public class logInScreen{
	
public logInScreen() {
	
		//create the stage 
		Stage stage = new Stage();
		
		//Create a gridpane layout to store content
		GridPane gridpane = new GridPane();
		//Create the horizontal gap between the elements in gridpane
		gridpane.setHgap(5);
		//create the vertical gap between the elements in gridpane
		gridpane.setVgap(5);
		//create the style for the gridpane background
		gridpane.setStyle("-fx-background-color: DCDCDC");
		
		//create the content for the gridpane & create the styling
		//create the textfield for the username
		TextField userName = new TextField();
		//create the styling for the textfields
		userName.setStyle("-fx-focus-color: #00FFFFFF");
		//create the passwordfield
		PasswordField passWord = new PasswordField();
		//create the style for the passwordfield
		passWord.setStyle("-fx-focus-color: #00FFFFFF");
		//create the login button
		Button login = new Button("Login");
		//set the styling for the button
		login.setStyle("-fx-border-color: B82F33");
		//create the register button
		Button register = new Button("Register");
		//create the register styling
		register.setStyle("-fx-border-color: B82F33");
		
		//create the imageviews for the two images		
		//create the image for the imageview
		Image profile = new Image("profile.png");
		//create the imageview
		ImageView profileView = new ImageView();
		//set the width and height of the imageview
		profileView.setFitHeight(32.5);
		profileView.setFitWidth(32.5);
		profileView.setImage(profile);
		
		//create the image
		Image passKey = new Image("key.png");
		//create the imageview
		ImageView passView = new ImageView();
		//set the styling for the imageview
		passView.setFitHeight(32.5);
		passView.setFitWidth(32.5);
		passView.setImage(passKey);
		
		//add the content to the gridpane
		gridpane.add(new Label("Username"),1,1);	
		gridpane.add(userName, 1, 2,2,1);
		gridpane.add(profileView, 0, 2);
		
		gridpane.add(new Label("Password"), 1, 3);
		gridpane.add(passWord, 1, 4,2,1);
		gridpane.add(passView, 0, 4);
		
		gridpane.add(login, 1, 5);
		gridpane.add(register, 2,5);
		
		//style the gridpane
		gridpane.setAlignment(Pos.CENTER);
		
		//create the scene
		Scene scene = new Scene(gridpane, 1064, 762);
		
		//show the stage
		stage.setScene(scene);
		stage.show();
		
	}

}

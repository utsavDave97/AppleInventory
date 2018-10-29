package Screens;

import Screens.homeScreen;
import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.text.Text;
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
		//create the borderPane to store the layout
		BorderPane pane = new BorderPane();
		pane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
		pane.setStyle("-fx-background-color: DCDCDC");
		//Create a gridpane layout to store content
		GridPane gridpane = new GridPane();
		//Create the horizontal gap between the elements in gridpane
		gridpane.setHgap(5);
		//create the vertical gap between the elements in gridpane
		gridpane.setVgap(5);
		//create the style for the gridpane background
		//create the content for the gridpane & create the styling
		Text title = new Text("AppleCore INC.");
		title.setStyle("-fx-font-size: 63; -fx-font-family: Quicksand;");
		//create a new 'color' var that will contain a selected color
		Color red = Color.web("#B82F33");
		title.setFill(red);
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
		login.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand;");
		//create the register button
		Button register = new Button("Register");
		//create the register styling
		register.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand;");
		
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
		//create the labels for the gridpane
		Label name = new Label("Username");
		name.setStyle("-fx-font-family: Quicksand");
		Label passwordLabel = new Label("Password");
		passwordLabel.setStyle("-fx-font-family: Quicksand");
		//add the content to the gridpane
		gridpane.add(name,1,1);	
		gridpane.add(userName, 1, 2,2,1);
		gridpane.add(profileView, 0, 2);
		
		gridpane.add(passwordLabel, 1, 3);
		gridpane.add(passWord, 1, 4,2,1);
		gridpane.add(passView, 0, 4);
		
		gridpane.add(login, 1, 5);
		gridpane.add(register, 2,5);
		
		//style the gridpane
		gridpane.setAlignment(Pos.CENTER);
		
		login.setOnAction(e->{
			new homeScreen();
			stage.close();
		});
		
		pane.setMargin(title, new Insets(40,0,0,0));
		pane.setTop(title);
		pane.setAlignment(title, Pos.CENTER);
		pane.setCenter(gridpane);
		//create the scene
		Scene scene = new Scene(pane, 1024, 768);
		
		//show the stage
		stage.setScene(scene);
		stage.show();
		
	}

}

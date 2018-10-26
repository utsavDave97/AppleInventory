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

public class logInScreen extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create a gridpane layout to store content
		GridPane gridpane = new GridPane();
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		gridpane.setStyle("-fx-background-color: DCDCDC");
		//create the content for the gridpane
		TextField userName = new TextField();
		userName.setStyle("-fx-focus-color: #00FFFFFF");
		PasswordField passWord = new PasswordField();
		passWord.setStyle("-fx-focus-color: #00FFFFFF");
		Button login = new Button("Login");
		login.setStyle("-fx-border-color: B82F33");
		Button register = new Button("Register");
		register.setStyle("-fx-border-color: B82F33");
		//create the imageviews for the two images		
		Image profile = new Image("profile.png");
		ImageView profileView = new ImageView();
		profileView.setFitHeight(32.5);
		profileView.setFitWidth(32.5);
		profileView.setImage(profile);
		
		Image passKey = new Image("key.png");
		ImageView passView = new ImageView();
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
		//add the children
		
		//create the scene
		Scene scene = new Scene(gridpane, 1064, 762);
		//show the stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

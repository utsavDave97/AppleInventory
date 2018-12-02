package Screens;

import Screens.homeScreen;
import Tables.PasswordTable;
import Tables.UserTable;
import Database.Const;
import JavaBean.Password;
import JavaBean.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		//create the textfield for the emailField
		TextField emailField = new TextField();
		//create the styling for the textfields
		emailField.setStyle("-fx-focus-color: #00FFFFFF");
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
		Label email = new Label("Email");
		email.setStyle("-fx-font-family: Quicksand");
		Label passwordLabel = new Label("Password");
		passwordLabel.setStyle("-fx-font-family: Quicksand");
		//add the content to the gridpane
		gridpane.add(email,1,1);	
		gridpane.add(emailField, 1, 2,2,1);
		gridpane.add(profileView, 0, 2);

		gridpane.add(passwordLabel, 1, 3);
		gridpane.add(passWord, 1, 4,2,1);
		gridpane.add(passView, 0, 4);

		gridpane.add(login, 1, 5);
		gridpane.add(register, 2,5);

		//style the gridpane
		gridpane.setAlignment(Pos.CENTER);

		login.setOnAction(e->{
			//create an instance of the usertable class
			UserTable usertable = new UserTable();
			//create an instance of the password class
			User user = new User();
			Password password = new Password();
			PasswordTable passwordtable = new PasswordTable();
			//implement the method to search for the user email
			//utilize the getuser field and save it as an int, this will grab the email_id in the database
			int cursorEmailField = usertable.getUser(emailField.getText());

			//create a string object representing the salt in the passwordfield next to email id. then append it onto the end of the users given password and see if matches the salted password in the database
			//pass the given salt to the end of the password field
			
			String dbConnectedSalt = password.grabSaltFromEmail(cursorEmailField);
			String hashedGivenPass = password.hashPassword(passWord.getText(), dbConnectedSalt);
			

			if(passwordtable.getPassword(hashedGivenPass, cursorEmailField)==true) {
				System.out.println("Correct credentials");
				new homeScreen();
			}else {
				System.out.println("false credentials");
				new logInScreen();
			}

			stage.close();
		});

		register.setOnAction(e->{
			new registerScreen();
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

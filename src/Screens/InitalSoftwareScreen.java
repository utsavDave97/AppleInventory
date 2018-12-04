package Screens;

import java.sql.Statement;

import Database.Const;
import Database.DBConnection;
import Database.ReadCredential;
import JavaBean.Password;
import JavaBean.User;
import JavaBean.UserRole;
import Tables.PasswordTable;
import Tables.UserRoleTable;
import Tables.UserTable;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitalSoftwareScreen {
	ReadCredential readCredential;
	public InitalSoftwareScreen() {

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
		
		Text Initialtitle = new Text("Initialize The Software");
		Initialtitle.setStyle("-fx-font-size: 30; -fx-font-family: Quicksand;");

		VBox topHbox=new VBox();
		topHbox.getChildren().addAll(title,Initialtitle);
		topHbox.setAlignment(Pos.TOP_CENTER);
		topHbox.setSpacing(30);
		

		//create the textfield for the emailField
		TextField dbUserField = new TextField();

		//create the styling for the textfields
		dbUserField.setStyle("-fx-focus-color: #00FFFFFF");

		//create the passwordfield
		PasswordField dbPassWord = new PasswordField();

		//create the style for the passwordfield
		dbPassWord.setStyle("-fx-focus-color: #00FFFFFF");

		//create the textfield for the emailField
		TextField dbName = new TextField();

				//create the styling for the textfields
		dbName.setStyle("-fx-focus-color: #00FFFFFF");
		
		//create the login button
		Button login = new Button("Initial Setting");

		//set the styling for the button
		login.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand;");

		
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
		
		//create the image
	   Image databaseImage = new Image("database.png");
		
		
		//create the imageview
		ImageView databaseView = new ImageView();

		//set the styling for the imageview
		databaseView.setFitHeight(32.5);
		databaseView.setFitWidth(32.5);
		databaseView.setImage(databaseImage);
		
		
		//create the image
		   Image serverImage = new Image("server.png");
		
			//create the imageview
			ImageView serverView = new ImageView();

			//set the styling for the imageview
			serverView.setFitHeight(32.5);
			serverView.setFitWidth(32.5);
			serverView.setImage(serverImage);
			//create the textfield for the emailField
			
			TextField serverAddress = new TextField();
            
					//create the styling for the textfields
			serverAddress.setStyle("-fx-focus-color: #00FFFFFF");
			//create the labels for the gridpane
			Label serverLabel = new Label("Server Address");
			serverLabel.setStyle("-fx-font-family: Quicksand");
			
			
			
			
			

		//create the labels for the gridpane
		Label email = new Label("User Name");
		email.setStyle("-fx-font-family: Quicksand");
		Label passwordLabel = new Label("Password");
		passwordLabel.setStyle("-fx-font-family: Quicksand");
		
		Label dbNameLabel=new Label("DataBase Name");
		dbNameLabel.setStyle("-fx-font-family: Quicksand");
		
		//add the content to the gridpane
		gridpane.add(email,2,1);	
		gridpane.add(dbUserField, 2, 2,2,1);
		gridpane.add(profileView, 0, 2);

		gridpane.add(passwordLabel, 2, 3);
		gridpane.add(dbPassWord, 2, 4,2,1);
		gridpane.add(passView, 0, 4);
		
		
		gridpane.add(dbNameLabel, 2, 5);
		gridpane.add(dbName, 2, 6,2,1);
		gridpane.add(databaseView, 0, 6);
		
		gridpane.add(serverLabel, 2, 7);
		gridpane.add(serverAddress, 2, 8,2,1);
		gridpane.add(serverView, 0, 8);
		
		
		

		gridpane.add(login, 3, 10);
//		gridpane.add(register, 2,5);

		//style the gridpane
		gridpane.setAlignment(Pos.CENTER);


//		register.setOnAction(e->{
//			new registerScreen();
//			stage.close();
//		});

		pane.setMargin(title, new Insets(40,0,0,0));
		pane.setTop(topHbox);
		pane.setAlignment(title, Pos.CENTER);
		pane.setCenter(gridpane);
		//create the scene
		Scene scene = new Scene(pane, 1024, 768);

		//show the stage
		stage.setScene(scene);
		stage.show();
		
		login.setOnAction(e->{
			//Step1: Write to credential file
			readCredential=new ReadCredential();
		 
		  String userName=dbUserField.getText();
		  String password=dbPassWord.getText();
		  String databaseName=dbName.getText();
		  String address=serverAddress.getText();
		  readCredential.WriteCredential(userName, password, databaseName, address, "no");
		  //Step2: Create Database table
		  DBConnection dabase;			
		  dabase= DBConnection.getInstance();
		  //Step 3: Insert into roles 
		  String query1="INSERT INTO "+Const.TABLE_ROLE+" VALUES(1,'clerk')";
		  String query2="INSERT INTO "+Const.TABLE_ROLE+" VALUES(2,'manager')";
		  String query3="INSERT INTO "+Const.TABLE_ROLE+" VALUES(3,'administrator')";
		  try {
			 Statement statement=dabase.getDbConnection().createStatement();
			 statement.executeUpdate(query1);
			 statement.executeUpdate(query2);
			 statement.executeUpdate(query3);

		  }catch (Exception e1) {
		e1.printStackTrace();
		
		}
		//Step4:Initial a admin for administrator
		//create a new usertable object
			UserTable usertable = new UserTable();

			//create a new passwordtable object
			PasswordTable passwordtable = new PasswordTable();

			//create a new userrole object
			UserRoleTable useroletable = new UserRoleTable();

			//create new user object
			User user = new User();
			

			//create a new password object
			Password passwordobj = new Password();

			//create a new userole object
			UserRole userrole = new UserRole();
			//create an instance of the password for the password hash
			Password hashedPass = new Password();
			//create a new passwouser.setEmail(email.getText());
			user.setFirstname("admin");
			user.setLastname("admin");
            user.setEmail("admin@gmail.com");

			//use the hashing method here to generate the string for the password

			String salt = passwordobj.saltGen().toString();
			//use the password methods
			passwordobj.setUser_password(hashedPass.hashPassword("admin", salt));

              userrole.setRole_Id(3);
			//send the information to the database
			usertable.createUser(user);
			passwordtable.createPassword(passwordobj, salt);
			useroletable.createUserRole(userrole);

			Alert successInsert = new Alert(AlertType.INFORMATION);
			successInsert.setTitle("Successful Initialization");
			successInsert.setHeaderText(null);
			successInsert.setContentText("Congratulation,You have initialization done!");
			successInsert.showAndWait();

		  
		  new logInScreen();
		  stage.close();
			
			
			
		});
		
		
		
	}
	
	

}

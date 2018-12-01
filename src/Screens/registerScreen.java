package Screens;

import javax.swing.JComboBox;

import Database.Const;
import JavaBean.Password;
import JavaBean.User;
import JavaBean.UserRole;
import Tables.PasswordTable;
import Tables.UserRoleTable;
import Tables.UserTable;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class registerScreen{

public registerScreen(){
	
	
			//create the stage to hold the content
			Stage stage = new Stage();
			//create an instance of the password for the password hash
			Password hashedPass = new Password();
			//create the borderPane to hold the information
			BorderPane borderpane = new BorderPane();
			//set the style of the borderpane
			borderpane.setStyle("-fx-background-color: DCDCDC");
			//import the google stylesheet for the quicksand font
			borderpane.getStylesheets().add("https://fonts.googleapis.com/css?family=Quicksand");
			//create the gridpane to hold the information
			GridPane pane = new GridPane();
			//set the alignment for the gridpane
			pane.setAlignment(Pos.CENTER);
			//set the hgap for the gripdane
			pane.setHgap(5);
			//set the vgap for the gridpane
			pane.setVgap(5);
			//set alignment for the gridpane
			pane.setAlignment(Pos.CENTER);
			//create an hbox to store the back,clear,register buttons
			HBox row = new HBox();
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
			//create a label for the email
			Label emailLabel = new Label("Email:");
			emailLabel.setStyle("-fx-font-family: Quicksand");
			//create a textfied for the email
			TextField email = new TextField();
			//create a label for the position
			Label positionLabel = new Label("Position:");
			positionLabel.setStyle("-fx-font-family: Quicksand");
			//create a combo box to store the position's
			ComboBox combo = new ComboBox();
			combo.setStyle("-fx-font-family: Quicksand");
			combo.getItems().addAll("Clerk");
			combo.getSelectionModel().select(0);
			//create a label for the password
			Label passwordLabel = new Label("Password:");
			passwordLabel.setStyle("-fx-font-family: Quicksand");
			//create a passwordfield for the password
			PasswordField passWord = new PasswordField();
			//create a button to traverse back to the login page
			Button back = new Button("Back");
			back.setStyle("-fx-border-color: B82F33; -fx-font-family: Quicksand; -fx-font-size: 12pt");
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
			
			pane.add(emailLabel, 0, 2);
			pane.add(email, 1, 2,3,1);
			
			pane.add(positionLabel, 0, 3);
			pane.add(combo, 1, 3,3,1);
			
			pane.add(passwordLabel, 0, 4);
			pane.add(passWord, 1, 4,3,1);
			
			//set an onclick listiner for the backbutton
			back.setOnAction(e->{
				new logInScreen();
				stage.close();
			});
			//set an onclick listener for the register button
			register.setOnAction(e->{
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
				//use the user methods
				
				if(user.searchAllEmails(email.getText()) == true){
					Alert emailTaken = new Alert(AlertType.INFORMATION);
					emailTaken.setTitle("Email already taken");
					emailTaken.setHeaderText(null);
					emailTaken.setContentText("Please select another email as this one is taken!");
					emailTaken.showAndWait();
					
					email.clear();
					passWord.clear();
					
				}else {
					user.setEmail(email.getText());
					user.setFirstname(fname.getText());
					user.setLastname(lname.getText());
					
					
					//use the hashing method here to generate the string for the password
					
					
					//use the password methods
					passwordobj.setUser_password(hashedPass.hashPassword(passWord.getText()));
					//use the userrole methods
					if(combo.getSelectionModel().getSelectedItem() == "Clerk") {
						userrole.setRole_Id(Const.CLERKROLEID);
					}else if(combo.getSelectionModel().getSelectedItem()=="manager") {
						userrole.setRole_Id(Const.MANAGERROLEID);
					}else if(combo.getSelectionModel().getSelectedItem()=="administrator") {
						userrole.setRole_Id(Const.ADMINISTRATORROLEID);
					}
					
					
					
					//send the information to the database
					usertable.createUser(user);
					passwordtable.createPassword(passwordobj);
					useroletable.createUserRole(userrole);
					
					Alert successInsert = new Alert(AlertType.INFORMATION);
					successInsert.setTitle("Successful Insert");
			    		successInsert.setHeaderText(null);
			    		successInsert.setContentText("Account has been created!");
			    		successInsert.showAndWait();
					
					
					fname.clear();
					lname.clear();
					email.clear();
					passWord.clear();
					
					new logInScreen();
					stage.close();
					
				}
				
				
			});
			//set an onclick listener for the clear button
			clearInfo.setOnAction(e->{
				fname.clear();
				lname.clear();
				email.clear();
				passWord.clear();
			});
			//add to hbox and set to bottom
			row.getChildren().addAll(back,clearInfo,register);
			row.setSpacing(30);
			row.setPadding(new Insets(0, 0, 250, 410));
			
			borderpane.setCenter(pane);
			borderpane.setBottom(row);
			Scene scene = new Scene(borderpane,1064,762);
			stage.setScene(scene);
			stage.show();
	}

	

}

import Screens.logInScreen;
import Screens.newTransactionScreen;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author utsav
 * This is the main file. This file launches Launch Screen after which Log In Screen appears
 *
 */
public class Main extends Application 
{
	public static Stage mainStage;
	
	//Declaring ProgressBar
	ProgressBar pb;
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		//Creating VBox
		VBox root = new VBox();
		
		//Adding CSS Class to VBox
		root.getStyleClass().add("root");
		
		//Setting Alignment of VBox
		root.setAlignment(Pos.CENTER);
		
		//Setting spacing of VBox
		root.setSpacing(20);
		
		//Creating a Scene of 1024 x 768
		Scene scene = new Scene(root,1024,768);
				
		//Creating ImageView
		ImageView appleIcon = new ImageView("apple.png");
		
		//Using JavaFX Effect on ImageView
		DropShadow ds = new DropShadow();
		ds.setRadius(5);
		ds.setOffsetX(8);
		ds.setOffsetY(8);
		ds.setColor(Color.BLACK);
		
		//Setting DropShadow effect to ImageView
		appleIcon.setEffect(ds);
		
		//Initializing ProgressBar
		pb = new ProgressBar();
		pb.setMinSize(400, 20);
		
		//This line is for CSS Class selectors
		//This line sets a class name for progress bar which I used css file
		pb.getStyleClass().add("red-bar");
		pb.setProgress(0);
		
		/**
		 * Creating an EventHanlder for KeyFrame
		 * Which means, after the ProgressBar loads it should pop up Log In Screen
		 */
		EventHandler<ActionEvent> onFinished = e->
		{
			new logInScreen();
			//new newTransactionScreen();
			primaryStage.close();
		};
		
		//Timeline processes KeyFrame after specified time 
		Timeline timeline = new Timeline();
		
		//KeyValue is created, it is given the property of ProgressBar which it tracks
		KeyValue keyValue = new KeyValue(pb.progressProperty(),1);
		
		//KeyFrame is defined and is given time per frame, and KeyValue is given as a parameter
		KeyFrame keyFrame = new KeyFrame(new Duration(4000),onFinished,keyValue);
		timeline.getKeyFrames().add(keyFrame);
		
		//Animation starts
		timeline.play();
		
		//Adding nodes to VBox
		root.getChildren().addAll(appleIcon,pb);
		
		//Initializing CSS Style sheet 
		root.getStylesheets().add(getClass().getResource("progress.css").toExternalForm());
		
		//Setting scene, showing scene
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

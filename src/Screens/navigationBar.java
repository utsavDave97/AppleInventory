/**
 * @author utsav
 */

package Screens;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class navigationBar 
{
	//create the construct for the navigation bar
	public static VBox createNavigationBar(Button newTransaction,
			Button completedTransaction,
			Button addStock,
			Button updateStock,			
			Button deleteStock,
			Button statisticScreen,
			Button accountManagement)
	{	
		//set the vbox
		VBox menu = new VBox();
		//set the id for the menu
		menu.setId("menu");
		//set the spacing for the menu 
		menu.setSpacing(5);
		//set the padding for the menu
		menu.setPadding(new Insets(5,5,5,5));

		//create a dropshadow for the menu
		DropShadow ds = new DropShadow();
		//create a setradius
		ds.setRadius(4);
		//set offset X
		ds.setOffsetX(6);
		//set offset Y
		ds.setOffsetY(6);
		//set the color
		ds.setColor(Color.GREY);

		/**
		 * Set the effects for the menu bar
		 */
		
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


		statisticScreen.setEffect(ds);
		statisticScreen.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-pref-height: 80;" + 
				"    -fx-pref-width: 200;" + 
				"    -fx-border-width: 3 3 3 3;" + 
				"    -fx-background-color: #B8B8B8;" + 
				"    -fx-font-size: 15;");
		statisticScreen.setOnMouseEntered(e->{
			statisticScreen.setScaleX(1.1);
			statisticScreen.setScaleY(1.1);
			statisticScreen.setStyle("-fx-font-family: Quicksand;"
					+ "-fx-pref-height: 80;" + 
					"    -fx-pref-width: 200;" + 
					"    -fx-border-width: 3 3 3 3;" + 
					"    -fx-background-color: #B8B8B8;" + 
					"    -fx-font-size: 15;"
					+ "-fx-border-color: #B82F33;" + 
					"    -fx-border-width: 3 3 3 3;");
		});
		statisticScreen.setOnMouseExited(e->{
			statisticScreen.setScaleX(1);
			statisticScreen.setScaleY(1);
			statisticScreen.setStyle("-fx-font-family: Quicksand;"
					+ "-fx-pref-height: 80;" + 
					"    -fx-pref-width: 200;" + 
					"    -fx-border-width: 3 3 3 3;" + 
					"    -fx-background-color: #B8B8B8;" + 
					"    -fx-font-size: 15;");
		}); 

		accountManagement.setEffect(ds);
		accountManagement.setStyle("-fx-font-family: Quicksand;"
				+ "-fx-pref-height: 80;" + 
				"    -fx-pref-width: 200;" + 
				"    -fx-border-width: 3 3 3 3;" + 
				"    -fx-background-color: #B8B8B8;" + 
				"    -fx-font-size: 15;");
		accountManagement.setOnMouseEntered(e->{
			accountManagement.setScaleX(1.1);
			accountManagement.setScaleY(1.1);
			accountManagement.setStyle("-fx-font-family: Quicksand;"
					+ "-fx-pref-height: 80;" + 
					"    -fx-pref-width: 200;" + 
					"    -fx-border-width: 3 3 3 3;" + 
					"    -fx-background-color: #B8B8B8;" + 
					"    -fx-font-size: 15;"
					+ "-fx-border-color: #B82F33;" + 
					"    -fx-border-width: 3 3 3 3;");
		});
		accountManagement.setOnMouseExited(e->{
			accountManagement.setScaleX(1);
			accountManagement.setScaleY(1);
			accountManagement.setStyle("-fx-font-family: Quicksand;"
					+ "-fx-pref-height: 80;" + 
					"    -fx-pref-width: 200;" + 
					"    -fx-border-width: 3 3 3 3;" + 
					"    -fx-background-color: #B8B8B8;" + 
					"    -fx-font-size: 15;");
		});


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
				deleteStock,
				statisticScreen,
				accountManagement
				
				);

		return menu;
	}

}

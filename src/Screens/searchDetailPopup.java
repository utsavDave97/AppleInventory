package Screens;

import java.text.DecimalFormat;
import java.util.ArrayList;

import JavaBean.Product;
import JavaBean.SaleItem;
import Screens.TableViewItems.SaleRecord;
import Screens.TableViewItems.ScreenSaleItem;
import Tables.ProductTable;
import Tables.SaleItemTable;
import Tables.SaleTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class searchDetailPopup 
{
	public searchDetailPopup(int saleId) 
	{
		/**********************************************************************
		 *                Basic Stage,Pane Definition                          *
		 ***********************************************************************/
        //create the stage 
		Stage popUpStage = new Stage();
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #DCDCDC;");
		
		/**********************************************************************
		 *               table View                       *
		 ***********************************************************************/	
		 final ObservableList<ScreenSaleItem> data =
			        FXCollections.observableArrayList();
		 
		  TableView<ScreenSaleItem> table = new TableView<ScreenSaleItem>();
		  table.setEditable(true);
		 // ScreenSaleItem(saleItem.getProd_Id(), productName, price, totPrice, saleItem.getSale_qty()+"")
		   // public ScreenSaleItem(int upcNumber, String name, String price,String totPrice,String quantity)  
		  TableColumn producIdCol=new TableColumn("prod_Id");
	       
		    producIdCol.setCellValueFactory(
	                new PropertyValueFactory<ScreenSaleItem, String>("upcNumber"));
		    producIdCol.setMinWidth(100);
		   
		    TableColumn productNameCol=new TableColumn("productName");
		       
		    productNameCol.setCellValueFactory(
	                new PropertyValueFactory<ScreenSaleItem, String>("name"));
		    productNameCol.setMinWidth(100);
		    
	        
	        
	        TableColumn priceCol = new TableColumn("Price");
	        priceCol.setMinWidth(100);
	        priceCol.setCellValueFactory(
	                new PropertyValueFactory<ScreenSaleItem, String>("price"));
	        
	        TableColumn totalPriceCol = new TableColumn("TotalPrice");
	        totalPriceCol.setMinWidth(100);
	        totalPriceCol.setCellValueFactory(
	                new PropertyValueFactory<ScreenSaleItem, String>("totPrice"));
	        
	        TableColumn quantityCol = new TableColumn("Qty");
	        quantityCol.setMinWidth(100);
	        quantityCol.setCellValueFactory(
	                new PropertyValueFactory<ScreenSaleItem, String>("quantity"));
	        table.getColumns().addAll(producIdCol,productNameCol,priceCol,totalPriceCol,quantityCol);

		SaleItemTable saleItemTable=new SaleItemTable();
		ProductTable productTable=new ProductTable();
		ArrayList<SaleItem> saleItems=saleItemTable.getAllSaleItems();
		ArrayList<SaleItem> filterSaleItems=new ArrayList<>();
		for (SaleItem saleItem : saleItems) {
		  if(saleItem.getSale_Id()==saleId) {
			  filterSaleItems.add(saleItem);
		
		  }	
			
		}
		
		for (SaleItem saleItem : filterSaleItems) 
		{
			Product product=productTable.getProduct(saleItem.getProd_Id());
			String productName=product.getProd_name();
			String price=product.getProd_price();
			Float totalprice=Float.parseFloat(product.getProd_price())*saleItem.getSale_qty();
			 DecimalFormat df = new DecimalFormat("####0.00");
		String	totprice=df.format(totalprice);
//             SaleTable saleTable=new SaleTable();
          
			data.add(new ScreenSaleItem(saleItem.getProd_Id(), productName, price, totprice, saleItem.getSale_qty()+""));
			 //public ScreenSaleItem(int upcNumber, String name, String price,String totPrice,String quantity)
		}
		
		root.setPadding(new Insets(20,20,20,20));
	    root.setCenter(table);
	    table.setItems(data);
	    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		Scene scene = new Scene(root, 600, 400);
		
		//show the stage
		popUpStage.setScene(scene);
		popUpStage.show();
	}

}

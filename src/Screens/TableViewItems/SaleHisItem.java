package Screens.TableViewItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class SaleHisItem{
	 private StringProperty saleTime;
	 private StringProperty operater;
	 private StringProperty tax;
	 private StringProperty totAmount;
	 private CheckBox checkDel;
	 private int saleId;
	 public SaleHisItem(String saletime,String operaterName,String taxNum,String totalAmount,int saleId) {
		 this.saleTime=new SimpleStringProperty(saletime);
		 this.operater=new SimpleStringProperty(operaterName);
		 this.tax=new SimpleStringProperty(taxNum);
		 this.totAmount=new SimpleStringProperty(totalAmount);
		 checkDel=new CheckBox();
		 this.saleId=saleId;

	 }
	public String getSaleTime() {
		return saleTime.get();
	}
	public void setSaleTime(String saleTime) {
		this.saleTime.set(saleTime);;
	}
	public String getOperater() {
		return operater.get();
	}
	public void setOperater(String operater) {
		this.operater.set(operater);;
	}
	public String getTax() {
		return tax.get();
	}
	public void setTax(String tax) {
		this.tax.set(tax);;
	}
	public String getTotAmount() {
		return totAmount.get();
	}
	public void setTotAmount(String totAmount) {
		this.totAmount.set(totAmount);;
	}
	public CheckBox getCheckDel() {
		return checkDel;
	}
	public void setCheckDel(CheckBox checkDel) {
		this.checkDel = checkDel;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	 
	 
	 
}


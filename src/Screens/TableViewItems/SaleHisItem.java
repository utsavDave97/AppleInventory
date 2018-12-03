package Screens.TableViewItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class SaleHisItem
{
	//create an saleTime so we can reference this later
	private StringProperty saleTime;
	//create an operater so we can reference this later
	private StringProperty operater;
	//create an tax so we can reference this later
	private StringProperty tax;
	//create an totAmount so we can reference this later
	private StringProperty totAmount;
	//create an checkDel so we can reference this later
	private CheckBox checkDel;
	//create an saleId so we can reference this later
	private int saleId;

	//create a construct for all params
	public SaleHisItem(String saletime,String operaterName,String taxNum,String totalAmount,int saleId) 
	{
		this.saleTime=new SimpleStringProperty(saletime);
		this.operater=new SimpleStringProperty(operaterName);
		this.tax=new SimpleStringProperty(taxNum);
		this.totAmount=new SimpleStringProperty(totalAmount);
		checkDel=new CheckBox();
		this.saleId=saleId;
	}

	public String getSaleTime() 
	{
		return saleTime.get();
	}

	public void setSaleTime(String saleTime) 
	{
		this.saleTime.set(saleTime);;
	}

	public String getOperater() 
	{
		return operater.get();
	}

	public void setOperater(String operater) 
	{
		this.operater.set(operater);;
	}

	public String getTax() {
		return tax.get();
	}

	public void setTax(String tax) 
	{
		this.tax.set(tax);;
	}

	public String getTotAmount() 
	{
		return totAmount.get();
	}

	public void setTotAmount(String totAmount) 
	{
		this.totAmount.set(totAmount);;
	}

	public CheckBox getCheckDel() 
	{
		return checkDel;
	}

	public void setCheckDel(CheckBox checkDel) 
	{
		this.checkDel = checkDel;
	}

	public int getSaleId() 
	{
		return saleId;
	}

	public void setSaleId(int saleId) 
	{
		this.saleId = saleId;
	} 

}


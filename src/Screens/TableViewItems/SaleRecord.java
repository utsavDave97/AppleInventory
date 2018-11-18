package Screens.TableViewItems;


public  class SaleRecord {

private  String saleTime;
private  String name;
private  String tax;
private  String total;

public SaleRecord(String saleTime, String name, String tax, String total) {
	super();
	this.saleTime = saleTime;
	this.name = name;
	this.tax = tax;
	this.total = total;
}
public String getSaleTime() {
	return saleTime;
}
public void setSaleTime(String saleTime) {
	this.saleTime = saleTime;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTax() {
	return tax;
}
public void setTax(String tax) {
	this.tax = tax;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}

		
	}
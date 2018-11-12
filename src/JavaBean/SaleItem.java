package JavaBean;
/**
 * @description This class is in responding to database sale_item_table
 * @author wjqcau
 *
 */
public class SaleItem {
 private String prod_Id;
 private int sale_Id;
 private int sale_qty;
 //Constructor without parameters
 public SaleItem() {}
 //Constructor with all parameters
public SaleItem(String prod_Id, int sale_Id, int sale_qty) {
	super();
	this.prod_Id = prod_Id;
	this.sale_Id = sale_Id;
	this.sale_qty = sale_qty;
}
public String getProd_Id() {
	return prod_Id;
}
public void setProd_Id(String prod_Id) {
	this.prod_Id = prod_Id;
}
public int getSale_Id() {
	return sale_Id;
}
public void setSale_Id(int sale_Id) {
	this.sale_Id = sale_Id;
}
public int getSale_qty() {
	return sale_qty;
}
public void setSale_qty(int sale_qty) {
	this.sale_qty = sale_qty;
}
 
 
}

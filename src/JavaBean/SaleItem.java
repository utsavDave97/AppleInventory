package JavaBean;
/**
 * @description This class is in responding to database sale_item_table
 * @author wjqcau
 *
 */
public class SaleItem {
 //create an prod_id so we can reference this for each user
 private int prod_id;
 //create an sale_id so we can reference this for each user
 private int sale_id;
 //create an sale_qty so we can reference this for each user
 private int sale_qty;
 
 
 //Constructor without parameters
 public SaleItem() {}
 //Constructor with all parameters
 public SaleItem(int prod_id, int sale_id, int sale_qty) 
 {
	super();
	this.prod_id = prod_id;
	this.sale_id = sale_id;
	this.sale_qty = sale_qty;
 }
public int getProd_Id() {
	return prod_id;
}
public void setProd_Id(int prod_id) {
	this.prod_id = prod_id;
}
public int getSale_Id() {
	return sale_id;
}
public void setSale_Id(int sale_id) {
	this.sale_id = sale_id;
}
public int getSale_qty() {
	return sale_qty;
}
public void setSale_qty(int sale_qty) {
	this.sale_qty = sale_qty;
}
 
 
}

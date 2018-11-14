package JavaBean;
/**
 * @description This class is in responding to database sale_item_table
 * @author wjqcau
 *
 */
public class SaleItem {
 private String prod_id;
 private int sale_id;
 private int sale_qty;
 
 
 //Constructor without parameters
 public SaleItem() {}
 //Constructor with all parameters
 public SaleItem(String prod_id, int sale_id, int sale_qty) 
 {
	super();
	this.prod_id = prod_id;
	this.sale_id = sale_id;
	this.sale_qty = sale_qty;
 }
public String getProd_Id() {
	return prod_id;
}
public void setProd_Id(String prod_id) {
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

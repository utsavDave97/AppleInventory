package JavaBean;
/**
 * @description This class is in responding to database stock_table
 * @author wjqcau
 *
 */
public class Stock {
 private int prod_id;
 private int prod_qty;
 
 public Stock() {}

public Stock(int prod_id, int prod_qty) {
	super();
	this.prod_id = prod_id;
	this.prod_qty = prod_qty;
}

public Stock(int prod_qty) {
	super();
	this.prod_qty = prod_qty;
}
 //getter and setter

public int getProd_Id() {
	return prod_id;
}

public void setProd_Id(int prod_id) {
	this.prod_id = prod_id;
}

public int getProd_qty() {
	return prod_qty;
}

public void setProd_qty(int prod_qty) {
	this.prod_qty = prod_qty;
}


}

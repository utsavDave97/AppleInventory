package JavaBean;
/**
 * @description This class is in responding to database stock_table
 * @author wjqcau
 *
 */
public class Stock {
 private String prod_id;
 private String prod_qty;
 
 public Stock() {}

public Stock(String prod_id, String prod_qty) {
	super();
	this.prod_id = prod_id;
	this.prod_qty = prod_qty;
}
 //getter and setter

public String getProd_Id() {
	return prod_id;
}

public void setProd_Id(String prod_id) {
	this.prod_id = prod_id;
}

public String getProd_qty() {
	return prod_qty;
}

public void setProd_qty(String prod_qty) {
	this.prod_qty = prod_qty;
}


}

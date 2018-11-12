package JavaBean;
/**
 * @description This class is in responding to database stock_table
 * @author wjqcau
 *
 */
public class Stock {
 private String prod_Id;
 private String prod_qty;
 
 public Stock() {}

public Stock(String prod_Id, String prod_qty) {
	super();
	this.prod_Id = prod_Id;
	this.prod_qty = prod_qty;
}
 //getter and setter

public String getProd_Id() {
	return prod_Id;
}

public void setProd_Id(String prod_Id) {
	this.prod_Id = prod_Id;
}

public String getProd_qty() {
	return prod_qty;
}

public void setProd_qty(String prod_qty) {
	this.prod_qty = prod_qty;
}


}

package JavaBean;
/**
 * @description class is in responding to database table:product_table
 * @author wjqcau
 *
 */
public class Product {
 private int prod_id;
 private String prod_name;
 private String prod_price;
 private String prod_taste;
 private String prod_qty;
 

public String getProd_qty() {
	return prod_qty;
}


public void setProd_qty(String prod_qty) {
	this.prod_qty = prod_qty;
}


//Constructor with no parameter
 public Product() {}
 
 
public Product(String prod_name, String prod_price, String prod_taste, String prod_qty) {
	super();
	this.prod_name = prod_name;
	this.prod_price = prod_price;
	this.prod_taste = prod_taste;
	this.prod_qty = prod_qty;
}


public Product(int prod_id, String prod_name, String prod_price, String prod_taste) {
	super();
	this.prod_id = prod_id;
	this.prod_name = prod_name;
	this.prod_price = prod_price;
	this.prod_taste = prod_taste;
}
//Getter and setter
public int getProd_Id() {
	return prod_id;
}
public void setProd_Id(int prod_id) {
	this.prod_id = prod_id;
}
public String getProd_name() {
	return prod_name;
}
public void setProd_name(String prod_name) {
	this.prod_name = prod_name;
}
public String getProd_price() {
	return prod_price;
}
public void setProd_price(String prod_price) {
	this.prod_price = prod_price;
}

public String getProd_taste() {
	return prod_taste;
}
public void setProd_taste(String prod_taste) {
	this.prod_taste = prod_taste;
} 
 
 
}


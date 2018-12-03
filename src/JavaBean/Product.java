package JavaBean;
/**
 * @description class is in responding to database table:product_table
 * @author wjqcau
 *
 */
public class Product {
//create an prod_id so we can reference this for each user
 private int prod_id;
//create an prod_name so we can reference this for each user
 private String prod_name;
//create an prod_price so we can reference this for each user
 private String prod_price;
//create an prod_taste so we can reference this for each user
 private String prod_taste;
 

//Constructor with no parameter
 public Product() {}
 

//create a construct that takes 3 params
public Product(String prod_name, String prod_price, String prod_taste) {
	super();
	this.prod_name = prod_name;
	this.prod_price = prod_price;
	this.prod_taste = prod_taste;
}
//create a construct that takes 2 params
public Product(String prod_name, String prod_price) {
	super();
	this.prod_name = prod_name;
	this.prod_price = prod_price;
}
//create a construct that takes 3 different params
public Product(int prod_id, String prod_name, String prod_price) {
	super();
	this.prod_id = prod_id;
	this.prod_name = prod_name;
	this.prod_price = prod_price;
}

//create a construct that takes all params
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
 

public String toString() {
	return this.prod_name + "   | $" + this.prod_price + "   | " + this.prod_taste;
}
 
}


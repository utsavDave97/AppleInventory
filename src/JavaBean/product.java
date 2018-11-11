package JavaBean;
/**
 * @description class is in responding to database table:product_table
 * @author wjqcau
 *
 */
public class product {
 private String prod_Id;
 private String prod_name;
 private String prod_price;
 private String origin_place;
 //Constructor with no parameter
 public product() {}
 //Constructor with parameters except for orgin_place
public product(String prod_Id, String prod_name, String prod_price) {
	super();
	this.prod_Id = prod_Id;
	this.prod_name = prod_name;
	this.prod_price = prod_price;
}
//Getter and setter
public String getProd_Id() {
	return prod_Id;
}
public void setProd_Id(String prod_Id) {
	this.prod_Id = prod_Id;
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
public String getOrigin_place() {
	return origin_place;
}
public void setOrigin_place(String origin_place) {
	this.origin_place = origin_place;
}
 
 
 
}


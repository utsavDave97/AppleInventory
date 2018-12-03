package JavaBean;

import java.sql.Timestamp;

public class Sale {
	//create an sale_id so we can reference this for each user
	private int sale_id;
	//create an email_id so we can reference this for each user
	private int email_id;
	//create an tax so we can reference this for each user
	private double tax;
	//create an total so we can reference this for each user
	private double total;
	//create an sale_time so we can reference this for each user
	private String sale_time;
	
	//Constructor
	public Sale() {	}
	//Constructor with some parameters
	public Sale(int email_id, float tax, float total) {
		super();
		this.email_id = email_id;
		this.tax = tax;
		this.total = total;
	}
	//Constructor with all parameters
	public Sale(int sale_id, int email_id, double tax, double total, String sale_time) {
		super();
		this.sale_id = sale_id;
		this.email_id = email_id;
		this.tax = tax;
		this.total = total;
		this.sale_time = sale_time;
	}
	//Constructor with 3 parameters
	public Sale(int email_id, double tax, double total, String sale_time) {
		super();
		this.email_id = email_id;
		this.tax = tax;
		this.total = total;
		this.sale_time = sale_time;
	}
	
	
	//getters and setters
	public int getSale_Id() {
		return sale_id;
	}
	public void setSale_Id(int sale_id) {
		this.sale_id = sale_id;
	}
	
	
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	
	
	public String getSale_time() {
		return sale_time;
	}
	public void setSale_time(String sale_time) {
		this.sale_time = sale_time;
	}
	
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}

package JavaBean;

import java.sql.Timestamp;

public class Sale {
	private int sale_id;
	private int email_id;
	private double tax;
	private double total;
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
	
	public Sale(int email_id, float tax, float total, String sale_time) {
		super();
		this.email_id = email_id;
		this.tax = tax;
		this.total = total;
		this.sale_time = sale_time;
	}
	
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

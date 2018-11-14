package JavaBean;

import java.sql.Timestamp;

public class Sale {
	private int sale_id;
	private String email;
	private String tax;
	private String total;
	
	//Constructor
	public Sale() {	}
	//Constructor with some parameters
	public Sale(String email, String tax, String total) {
		super();
		this.email = email;
		this.tax = tax;
		this.total = total;
	}
	//Constructor with all parameters=========becarefull using this one, sale_Id will be created by 
	 //database automatically
	public Sale(int sale_id, String email, String tax, String total) {
		super();
		this.sale_id = sale_id;
		this.email = email;
		this.tax = tax;
		this.total = total;
	}
	public int getSale_Id() {
		return sale_id;
	}
	public void setSale_Id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}

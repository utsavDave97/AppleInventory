package JavaBean;

import java.sql.Timestamp;

public class Sale {
	private int sale_Id;
	private String email;
	private String tax;
	private String total;
	private Timestamp sale_time;
	//Constructor
	public Sale() {	}
	//Constructor with some parameters
	public Sale(String email, String tax, String total, Timestamp sale_time) {
		super();
		this.email = email;
		this.tax = tax;
		this.total = total;
		this.sale_time = sale_time;
	}
	//Constructor with all parameters=========becarefull using this one, sale_Id will be created by 
	 //database automatically
	public Sale(int sale_Id, String email, String tax, String total, Timestamp sale_time) {
		super();
		this.sale_Id = sale_Id;
		this.email = email;
		this.tax = tax;
		this.total = total;
		this.sale_time = sale_time;
	}
	public int getSale_Id() {
		return sale_Id;
	}
	public void setSale_Id(int sale_Id) {
		this.sale_Id = sale_Id;
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
	public Timestamp getSale_time() {
		return sale_time;
	}
	public void setSale_time(Timestamp sale_time) {
		this.sale_time = sale_time;
	}
	
	
	
	

}

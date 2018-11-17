package Database;

public class Const 
{
	//create a constant for each of the table and column names
	
	/*---------------Creating Constants for User Table------------------*/
	public static final String TABLE_USER = "user";
	public static final String USER_COLUMN_EMAIL_ID = "email_id";
	public static final String USER_COLUMN_EMAIL = "email";
	public static final String USER_COLUMN_FNAME = "fname";
	public static final String USER_COLUMN_LNAME = "lname";
	
	/*---------------Creating Constants for Password Table------------------*/
	public static final String TABLE_PASSWORD = "password";
	public static final String PASSWORD_COLUMN_EMAIL_ID = "email_id";
	public static final String PASSWORD_COLUMN_PASS = "password";
	
	/*---------------Creating Constants for Role Table------------------*/
	public static final String TABLE_ROLE = "role";
	public static final String ROLE_COLUMN_ID = "role_id";
	public static final String ROLE_COLUMN_NAME = "role_name";
	
	/*---------------Creating Constants for User Role Table------------------*/
	public static final String TABLE_USER_ROLE = "user_role";
	public static final String USER_ROLE_COLUMN_EMAIL_ID = "email_id";
	public static final String USER_ROLE_COLUMN_ID = "role_id";
	
	/*---------------Creating Constants for Product Table------------------*/
	public static final String TABLE_PRODUCT = "product";
	public static final String PRODUCT_COLUMN_ID = "prod_id";
	public static final String PRODUCT_COLUMN_NAME = "prod_name";
	public static final String PRODUCT_COLUMN_PRICE = "prod_price";
	public static final String PRODUCT_COLUMN_TASTE = "prod_taste";
	
	/*---------------Creating Constants for Stock Table------------------*/
	public static final String TABLE_STOCK = "stock";
	public static final String STOCK_COLUMN_ID = "prod_id";
	public static final String STOCK_COLUMN_QUANTITY = "prod_qty";
	
	/*---------------Creating Constants for Sale Table------------------*/
	public static final String TABLE_SALE = "sale";
	public static final String SALE_COLUMN_ID = "sale_id";
	public static final String SALE_COLUMN_EMAIL = "email";
	public static final String SALE_COLUMN_TAX = "tax";
	public static final String SALE_COLUMN_TOTAL = "total";
	
	/*---------------Creating Constants for Sale Item Table------------------*/
	public static final String TABLE_SALE_ITEM = "sale_item";
	public static final String SALE_ITEM_COLUMN_PROD_ID = "prod_id";
	public static final String SALE_ITEM_COLUMN_SALE_ID = "sale_id";
	public static final String SALE_ITEM_COLUMN_QUANTITY = "sale_qty";
	
	
	/*---------------Creating User Table------------------*/
	public static final String CREATE_TABLE_USER = 
				"CREATE TABLE " + TABLE_USER + " (" +
				USER_COLUMN_EMAIL_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
				USER_COLUMN_EMAIL + " VARCHAR(30) NOT NULL, " + 
				USER_COLUMN_FNAME + " VARCHAR(20) NOT NULL, " + 
				USER_COLUMN_LNAME + " VARCHAR(20) NOT NULL);";
	
	/*---------------Creating Password Table------------------*/
	public static final String CREATE_TABLE_PASSWORD = 
			"CREATE TABLE " + TABLE_PASSWORD + " (" +
			PASSWORD_COLUMN_EMAIL_ID + " INT NOT NULL PRIMARY KEY, " +
			PASSWORD_COLUMN_PASS + " VARCHAR(60) NOT NULL, " +
			"FOREIGN KEY (" + PASSWORD_COLUMN_EMAIL_ID + ") REFERENCES " + 
			TABLE_USER + "(" + USER_COLUMN_EMAIL_ID + "));";
	
	/*---------------Creating Role Table------------------*/
	public static final String CREATE_TABLE_ROLE =
			"CREATE TABLE " + TABLE_ROLE + " (" +
			ROLE_COLUMN_ID + " INT NOT NULL PRIMARY KEY, " +
			ROLE_COLUMN_NAME + " VARCHAR(15) NOT NULL);";
	
	/*---------------Creating User Role Table------------------*/
	public static final String CREATE_TABLE_USER_ROLE =
			"CREATE TABLE " + TABLE_USER_ROLE + " (" +
			USER_ROLE_COLUMN_EMAIL_ID + " INT NOT NULL, " +
			USER_ROLE_COLUMN_ID + " INT NOT NULL, " +
			"PRIMARY KEY (" + USER_ROLE_COLUMN_EMAIL_ID + "," + USER_ROLE_COLUMN_ID + ")," +
			"FOREIGN KEY (" + USER_ROLE_COLUMN_EMAIL_ID + ") REFERENCES " + 
			TABLE_USER + "(" + USER_COLUMN_EMAIL_ID + "), " +
			"FOREIGN KEY (" + USER_ROLE_COLUMN_ID + ") REFERENCES " + 
			TABLE_ROLE + "(" + ROLE_COLUMN_ID + "));";
	
	/*---------------Creating Product Table------------------*/
	public static final String CREATE_TABLE_PRODUCT = 
			"CREATE TABLE " + TABLE_PRODUCT + " (" +
			PRODUCT_COLUMN_ID + " INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
			PRODUCT_COLUMN_NAME + " VARCHAR(20) NOT NULL, " +
			PRODUCT_COLUMN_PRICE + " VARCHAR(10) NOT NULL, " +
			PRODUCT_COLUMN_TASTE + " VARCHAR(30) NOT NULL);";
	
	/*---------------Creating Stock Table------------------*/
	public static final String CREATE_TABLE_STOCK =
			"CREATE TABLE " + TABLE_STOCK + " (" +
			STOCK_COLUMN_ID + " INT NOT NULL PRIMARY KEY, " +
			STOCK_COLUMN_QUANTITY + " VARCHAR(10) NOT NULL, " +
			"FOREIGN KEY (" + STOCK_COLUMN_ID + ") REFERENCES " +
			TABLE_PRODUCT + "(" + PRODUCT_COLUMN_ID + "));";
	
	/*---------------Creating Sale Table------------------*/
	public static final String CREATE_TABLE_SALE =
			"CREATE TABLE " + TABLE_SALE + " (" +
			SALE_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
			SALE_COLUMN_EMAIL + " INT NOT NULL, " +
			SALE_COLUMN_TAX + " VARCHAR(10) NOT NULL, " +
			SALE_COLUMN_TOTAL + " VARCHAR(10) NOT NULL, " +
			"FOREIGN KEY (" + SALE_COLUMN_EMAIL + ") REFERENCES " +
			TABLE_USER + "(" + USER_COLUMN_EMAIL_ID + "));";
			
	/*---------------Creating Sale Item Table------------------*/
	public static final String CREATE_TABLE_SALE_ITEM =
			"CREATE TABLE " + TABLE_SALE_ITEM +" (" +
			SALE_ITEM_COLUMN_PROD_ID + " INT NOT NULL, " + 		
			SALE_ITEM_COLUMN_SALE_ID + " INT NOT NULL, " +
			SALE_ITEM_COLUMN_QUANTITY + " INT NOT NULL, " +
			"PRIMARY KEY (" + SALE_ITEM_COLUMN_PROD_ID + "," + SALE_ITEM_COLUMN_SALE_ID + ")," +
			"FOREIGN KEY (" + SALE_ITEM_COLUMN_PROD_ID + ") REFERENCES " +
			TABLE_PRODUCT + "(" + PRODUCT_COLUMN_ID + "), " +
			"FOREIGN KEY (" + SALE_ITEM_COLUMN_SALE_ID + ") REFERENCES " +
			TABLE_SALE + "(" + SALE_COLUMN_ID + "));";
}


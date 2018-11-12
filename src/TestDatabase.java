import Database.DBConnection;

public class TestDatabase {
/**
 * @description This class just for test the database connection and all our slq script here.
 *               This class mainly test all the DAO's classes to make sure they work well.
  *              After development , this class will be deleted
 * @param args
 */
	public static void main(String[] args) {
		//Test 1: database connection
		DBConnection dabase;
		try {
			DBConnection dababase= DBConnection.getInstance();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		/*******************************************************************************************
		 *           We will implement CRUD to make sure all Dao's classes works well              *
		 *          
		 *******************************************************************************************/
		
		//===============================For UserDao Test: write codes below====================
		
		//Test 2: Insert data to the table
		//Test 3:Query data from table
		//Test 4:update data
		//Test 5 Delete
		//Test 6 Insert
		
		
		
		
		//===============================For ProductDao Test:====================================
		
		//Test 2: Insert data to the table
		//Test 3:Query data from table
		//Test 4:update data
		//Test 5 Delete
		//Test 6 Insert
		

	}

}

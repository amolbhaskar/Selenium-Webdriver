package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {

	public static void main(String[] args) {
		
		//Register the driver
		DriverManager.registerDriver(new oracle.jdbc.driver.oracleDriver());
		
		/*Another way to register a driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");*/
		
		//establish connection with the db
		try{
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "scott", "toger");
		
		
		//Create a sql statement
		Statement stmt = con.createStatement();
		
		//Execute the statement
		ResultSet rs = stmt.executeQuery("Select * from emptable");
		
		//all rows of emptable are in rs object now. Retrieve column data from rs and display
		while(rs.next()){
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getFloat(3));
		}
		
		
		//close the connection
		con.close();
	
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}

}
}
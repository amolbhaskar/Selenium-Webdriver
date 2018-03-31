package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		
		DriverManager.registerDriver(new oracle.jdbc.driver.oracleDriver());
		
		Connection con;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "scott", "toger");
		
		//Create a statement to insert a row
		Statement stmt = con.createStatement();
		int norows = stmt.executeUpdate("insert into emptable(empno) values(777)");
		
		System.out.println("Number of rows affected: "+ norows);
		
		//insert second row
		norows = stmt.executeUpdate("insert into emptable values (779, 'ab', 899.00)");
		System.out.println("Number of rows affected: "+ norows);
		
		//close connection
		con.close();

	}

}

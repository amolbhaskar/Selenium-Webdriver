package Day6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//https://www.youtube.com/watch?v=HDRoiK0BWYs

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//write the selenium script here
		String firstname = "abhaskar";
		String lastname = "smith";
		String pw="dollar$";
		String email = "ab@aol.com";
		String zip="89789";
		
		String vurl = "https://www.dollartree.com/user/subscribe.jsp";
		
		WebDriver driver = new FirefoxDriver();
		
		
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("emailAddress")).sendKeys(email);
		driver.findElement(By.id("zipCode")).sendKeys(pw);
		driver.findElement(By.name("submit")).click();
		
		
		//jdbc=API for java programs to connect to the sql DB
		//connection url
		String dburl = "jdbc:mysql://localhost:3306/";
		
		String databaseName = "mydatabase";
		
		String username = "root";
		
		String password = "root";
		
		String query = "select * from signupdetails ORDER BY signupid DESC LIMIT 1";
		
		//load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get connection to the db
		Connection con = DriverManager.getConnection(dburl+databaseName, username, password);
		
		//create statement object
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery(query);
		
		//loop to get all rows data
		result.next();
			System.out.println(result.getString("fname"));
			System.out.println(result.getString("lname"));
			System.out.println(result.getString("pw"));
			System.out.println(result.getString("email"));
			System.out.println(result.getString("zip"));
			
			//DB TESTING
			if(result.getString("fname").equalsIgnoreCase(firstname))
				System.out.println("first name is incorrect");
			//use same for other fields
			
		//close db conneciton
		con.close();
	
	}

}

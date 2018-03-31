package Day12;
//Here is the sample code which will start typing "vam" and then capture all search suggestions .
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchList {

	WebDriver driver;
	 
	 @BeforeTest
	 public void start(){
	   driver = new FirefoxDriver(); 
	 }
	  
	 @Test
	  public void SearchSuggestion() {
	  
	  driver.get("http://google.com");
	  driver.findElement(By.id("lst-ib")).sendKeys("vam");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	   WebElement table = driver.findElement(By.className("sbdd_b")); 
	   List rows = table.findElements(By.tagName("tr")); 
	   Iterator i = rows.iterator(); 
	   System.out.println("-----------------------------------------"); 
	   while(i.hasNext()) { 
	           WebElement row = (WebElement) i.next(); 
	           List columns = row.findElements(By.tagName("td")); 
	           Iterator j = columns.iterator(); 
	           while(j.hasNext()) { 
	                   WebElement column = (WebElement) j.next(); 
	                   System.out.println(column.getText()); 
	           } 
	           System.out.println(""); 
	            
	   System.out.println("-----------------------------------------"); 
	   } 
	  } 
	}


package Day12;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTable {
	
	public static WebDriver driver = null;
	public static String vURL;
	
	@BeforeTest
	public void setup(){
		vURL = "http://only-testing-blog.blogspot.in/2014/05/form.html";
		System.setProperty("WebDriver.Gecko.driver", ".exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(vURL);
	}
	
	@AfterTest
	public void tearDown(){
		if(driver!=null){
			driver.quit();
		}
	}
	
	/*
	 * 1. locate the table
	 * 2. find number of rows
	 * 3. loop
	 * 4. find number of cols
	 * 5. loop
	 * 6. get celtext
	 */
		
	@Test
	public void handle_dynamic_webtable(){
	
	//to locate table
	WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
			
	//to locate rows of table
	List<WebElement>rows = mytable.findElements(By.tagName("tr"));
	
	//count the number of rows
	int rowcount = rows.size();
	System.out.println("Number of rows: "+ rowcount);
	
	//loop to execute till the last row of table
	for(int row= 1; row<rowcount; row++){
		
		//to locate column(cell) of that specific row
		List<WebElement>cols = rows.get(row).findElements(By.tagName("td"));
		
		//to calculate number of cols (cells) in that specific row
		int colcount = cols.size();
		System.out.println("Number of cols: "+ colcount);
		
		//Loop will execute till the last row of the table
		for(int col=0; col<colcount; col++){
			
			//to retrieve data/text from thaht specific column/cell 
			String text = cols.get(col).getText();
			
			System.out.println("Cell value of row number "+row + "and column number " +col+ "is "+text);
		}
	}
	}

}

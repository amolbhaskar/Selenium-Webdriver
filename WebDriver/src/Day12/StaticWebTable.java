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

public class StaticWebTable {
	
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
	
	@Test
	public void handlestatictable(){
		
		WebElement mytable = driver.findElement(By.xpath("//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
		System.out.println(mytable.getText());
		
		List<WebElement>rows = mytable.findElements(By.tagName("tr"));
		int nrows = rows.size();
		System.out.println(nrows);
		
		List<WebElement>cols = mytable.findElements(By.tagName("td"));
		int ncols = cols.size();
		System.out.println(ncols);
		
		
		
	}

}

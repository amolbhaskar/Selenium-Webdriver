package Day5;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tooltip {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void launchBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		driver.get("http://www.seleniumhq.org/");
	}

	@Test
	public void testTooltip(){
		WebElement element = driver.findElement(By.xpath("//*[@id='header']/h1/a"));
		String tooltiptext = element.getAttribute("title");
		System.out.println(tooltiptext);
		Assert.assertEquals("Return to Selenium home page", tooltiptext);
	}
	
	@AfterTest
	public void teardown(){
		if(driver != null){
			driver.close();
		}
	}
}

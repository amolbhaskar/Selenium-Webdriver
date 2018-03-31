package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;

public class Capturescrnonfailure {

	WebDriver driver;
	
	@Test
	public void facebookTest()
	{
        
	driver = new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.id("emailxxx")).sendKeys("amol_bhaskar@yahoo.com");
	
	}

	//screenshot method is written in Library package
	@AfterMethod
	public void takescrnshotonFailure(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.screenshot(driver, result.getName());
		}
		
		driver.quit();
	}

}

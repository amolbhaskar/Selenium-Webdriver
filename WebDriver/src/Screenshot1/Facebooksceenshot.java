package Screenshot1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import Library.Utility;

public class Facebooksceenshot {

	WebDriver driver;
	
	@Test
	public void sccreenshotTest() throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		//calling static method from Library folder
		Utility.screenshot(driver, "FB Homepage");
		
		System.out.println("Loginpage Screenshot captured");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("amol_bhaskar@yahoo.com");
		
		driver.findElement(By.id("u_0_l")).click();
		
		Utility.screenshot(driver, "Sign In Error");
		
		System.out.println("Error message Screenshot captured");
		
		driver.quit();
	}
}

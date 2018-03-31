package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpliciteWait {
	
	public static WebDriver driver = null;
	public static String vurl = "https://www.google.co.in/";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get(vurl);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		
		
		driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
		
		//using explicit wait
		
		expliciteWait(driver, "Downloads - Selenium");
		driver.findElement(By.partialLinkText("Downloads - Selenium")).click();

	}

	
	public static void expliciteWait(WebDriver driver, String text)
	{
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
	}
}

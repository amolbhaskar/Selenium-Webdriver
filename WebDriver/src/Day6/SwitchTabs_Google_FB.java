package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTabs_Google_FB {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		driver.get("http://bing.com");
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000l);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
		System.out.println(driver.getTitle());
		

	}

}

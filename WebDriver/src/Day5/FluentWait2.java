package Day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait2 {

	public static WebDriver driver = null;
	public static String vurl = "https://www.google.co.in/";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get(vurl);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("btnK")).click();
		
		//waiting 30 seconds for element to be present 
		//polling every 5 seconds to check whether the element is getting displayed or not
		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("btnK")));//xpath is for example only
}
}
package Day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Flipcart {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.flipkart.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);

		Thread.sleep(5000l);
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[1]/a/span[1]"));
		Actions act = new Actions(driver);
		
		Thread.sleep(5000l);
		act.moveToElement(mainMenu).build().perform();;
		
		driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[1]/ul/li[2]/ul/li[1]/ul/li[6]/a/span")).click();
		
		//driver.close();
		
		/*
		 * With some of the browser it happens that once mouse hover action is performed, 
		 * the menu list disappear with in the fractions of seconds before 
		 * Selenium identify the next submenu item and perform click action on it. 
		 * In that case it is better to use ‘perform()’ action on the main menu to hold the menu list 
		 * till the time Selenium identify the sub menu item and click on it.
		 * 
		 * WebElement element = driver.findElement(By.linkText("Product Category"));
 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).perform();
 
        WebElement subElement = driver.findElement(By.linkText("iPads"));
 
        action.moveToElement(subElement).click().perform();

		 */
		
	}

}

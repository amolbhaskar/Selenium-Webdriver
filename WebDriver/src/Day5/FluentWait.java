package Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.Function;


public class FluentWait {
	
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
		
		//wait for an element - "webdriver" to be displayed 
		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
				{
				  public WebElement apply(WebDriver driver) {
				
				/*	  WebElement ele = driver.findElement(by.xpath("//*[@id='demo']"));
					  
					  String value = ele.getAttribute("innerHTML");
					  
					  if(value.equals("webdriver")){
						  return ele;
					  }else{
						  
						  system.out.println("text which is coming on screen: "+value)
						  //keep polling until value = webdriver displayed
						  return null;
					  }*/
				
				  return driver.findElement(By.id("webdriver"));
				}
				});
		
		System.out.println("element is displayted?"+ element.isDisplayed());

}
}

/*//stale element reference exception

WebElement googleSearchBar = driver.findElement(By.id("q"));

WebDriverWait explicitlywait = new WebDriverWait(driver, 10);
explicitlywait.until(ExpectedConditions.stalenessOf(googleSearchBar));

//fluent wait with function
//advantage  - you can use any type of object as input and output/return

		List<Class<? extends Throwable>> exceptionList = new ArrayList<Class<? extends Throwable>>(){
														{
														add(NoSuchElementException.class);
														add(StaleElementReferenceException.class);
														}
														
Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
					.withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoreAll(Arrays.asList(NoSuchElementException.class,StaleElementReferenceException.class))
					//.ignoreAll(exceptionList)
					.withMessage("The message you will see in case of time out exception");

java.util.function.Function<WebDriver, WebElement> weFindElementFoo = new java.util.function.Function<WebDriver, WebElement>() {
	
	
	public WebElement apply(WebDriver driver) {
		
		return driver.findElement(By.id("q"));
	}
};

use the function in the script
        wait.until(weFindElementFoo)

//Predicate - like function but of boolean type
 * only need to supply with an input...output/return is always boolean
 */
/*		Wait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoreAll(Arrays.asList(NoSuchElementException.class,StaleElementReferenceException.class))
				//.ignoring(NoSuchFrameException)
				.withMessage("message upon timeout");
		
		Predicate<WebDriver> findElement = new Predicate<WebDriver>() {

			public boolean test(WebDriver driver) {
				
				return driver.findElements(By.id("q")).size() > 0;
			};
	} 
*
*/
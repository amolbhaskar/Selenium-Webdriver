package Day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datepicker {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.delta.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id='originCity']")).sendKeys("SFO");
		
		driver.findElement(By.xpath("//*[@id='destinationCity']")).sendKeys("LAX");
		
		//JavascriptExecutor interface is implemented through the RemoteWebDriver class 
		//(not part of the core set of API) 
		//So executescript() method wont be available unless casting is done
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//by xpath
		js.executeScript("document.getElementById('departureDate').value='09/30/2016'");
		
		//by CSS selector
		js.executeScript("document.querySelector('#returnDate').value='10/25/2016'");
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='findFlightsSubmit']")));
		driver.findElement(By.xpath("//*[@id='findFlightsSubmit']")).click();*/
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='findFlightsSubmit']")));
		element.click();
	
		driver.quit();
	}

}

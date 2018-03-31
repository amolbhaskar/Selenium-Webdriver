package Day3;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar2 {

	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.united.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		
		
		driver.findElement(By.xpath("//*[@id='specificDateSection']/div[1]/label")).click();
		
		List<WebElement> calendar_dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table//td"));
		
		for(int i=0; i<calendar_dates.size(); i++){
			String date = calendar_dates.get(i).getText();
			
			if(date.equalsIgnoreCase("28")){
				calendar_dates.get(i).click();
				break;
			}
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('ReturnDate').value = '2017/04/29'");
		
	
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='flightBookingSubmit']")));
		element.click();
		
		//driver.findElement(By.xpath("//*[@id='flightBookingSubmit']")).click();
		
		
		
		
	}

}

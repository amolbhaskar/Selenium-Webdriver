package Day3;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calendar {

	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.redbus.in";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='search']/div/div[3]/span")).click();
		
		List<WebElement> calendar_dates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table//td"));
		
		for(int i=0; i<calendar_dates.size(); i++){
			String date = calendar_dates.get(i).getText();
			
			if(date.equalsIgnoreCase("28")){
				calendar_dates.get(i).click();
				break;
			}
		}
			
	}

}

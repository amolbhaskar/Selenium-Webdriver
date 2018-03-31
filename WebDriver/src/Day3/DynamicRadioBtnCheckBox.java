package Day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicRadioBtnCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//custom xpath
		List<WebElement>rdbtn = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
		for(WebElement ele : rdbtn)
		{
			String rdvalue = ele.getAttribute("value");
			
			System.out.println(rdvalue);
			
			if(rdvalue.equalsIgnoreCase("Ruby"))
			{
				
				ele.click();
				break;
			}
		}
		
		List<WebElement>listbox = driver.findElements(By.xpath("//input[@type='checkbox' and @name='lang']"));
		
		for(WebElement list : listbox)
		{
			String lvalue = list.getAttribute("id");
			
			if(lvalue.equalsIgnoreCase("code"))
			{
				list.click();
				break;
			}
			
		}
		
		//Thread.sleep(5000);
		//driver.quit();
	}
	

}

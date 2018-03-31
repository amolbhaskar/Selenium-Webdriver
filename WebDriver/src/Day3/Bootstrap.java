package Day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Bootstrap {
	
	public static WebDriver driver;

	public static void main(String[] args) 
	{
		
		driver = new FirefoxDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='menu1']")).click();
		
		// 4 MATCHING NODES
		List<WebElement>mainmenu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		
		for(WebElement dd_menu : mainmenu)
		{
			String innerhtml = dd_menu.getAttribute("innerHTML");
			System.out.println(innerhtml);
			
			if(innerhtml.contentEquals("JavaScript"))
			{
				dd_menu.click();
				break;
			}
		}
		
	
	}

}

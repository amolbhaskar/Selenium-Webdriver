package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinks_Wikipedia {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.wikipedia.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		//get the size of all links on the page
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		/*for(WebElement temp:links){
			Thread.sleep(8000l);
			System.out.println(temp.getText());
		}*/
		
		//get the size and text of search language dropdown
		
		List<WebElement>listbox = driver.findElements(By.tagName("option"));
		System.out.println(listbox.size());
		
		
		for(WebElement list : listbox){
			System.out.println(list.getText());
		}
		
		//get the values by attribute
		List<WebElement>attribute = driver.findElements(By.tagName("option"));
		
		for(int i=0; i<attribute.size(); i++)
		{
			System.out.println(attribute.get(i).getAttribute("lang"));
		}
		
		driver.findElement(By.xpath("//*[@id='searchLanguage']")).sendKeys("az");
		//listbox.get(0).sendKeys("az");
		

	}

}

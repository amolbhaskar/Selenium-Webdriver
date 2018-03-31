package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dropdown {

public static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
		driver.navigate().to("http://qtpselenium.com/home/contact_trainer");
		
		WebElement droplist = driver.findElement(By.name("country_id"));
		droplist.sendKeys("India");
		List<WebElement> options = droplist.findElements(By.tagName("option"));
		System.out.println(options.size());
		
		for(int i=0; i<options.size(); i++){
			System.out.println(options.get(i).getText()+"--------"+options.get(i).getAttribute("selected"));
		}
		
}
}
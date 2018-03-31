package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinksLoop2 {

	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
		driver.navigate().to("http://shopping.rediff.com/?sc_cid=inhome_icon");
		
		
		//*[@id='popular_cat']/h3[1]/a
		//*[@id='popular_cat']/h3[2]/a
		
		
		//*[@id='popular_cat']/h3[14]/a
		//create a common xpath for all links
		//*[@id='popular_cat']/h3/a
		
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='popular_cat']/h3/a"));
		System.out.println(links.size());
		
		for(int i=0; i<links.size(); i++){
			String text = links.get(i).getText();
			System.out.println(text);
			links.get(i).click();
			System.out.println(driver.getTitle());
			driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
			driver.findElements(By.xpath("//*[@id='popular_cat']/h3/a"));
			
		}
		
		
	}		
}

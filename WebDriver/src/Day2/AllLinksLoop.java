package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinksLoop {

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
		
		String part1 = "//*[@id='popular_cat']/h3[";
		String part2 = "]/a";
		int i=1;
		//for(int i=1; i<=14; i++){
		while(isElementPresent(part1+i+part2)){
			String text = driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
			driver.navigate().back();
			i++;
		}

	}

	public static boolean isElementPresent(String xpath) {
		List<WebElement> allElements = driver.findElements(By.xpath(xpath));
		if(allElements.size() == 0)
		return false;
		else
		return true;
	}
}

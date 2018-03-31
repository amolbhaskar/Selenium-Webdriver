package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BlockLinks_Wikipedia {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.wikipedia.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
	WebElement footer =	driver.findElement(By.xpath("//div[@class='footer']"));
	
	List<WebElement> flinks = footer.findElements(By.tagName("a"));
		System.out.println(flinks.size());
		
	for(int i=0; i<flinks.size();i++){
		System.out.println(flinks.get(i).getAttribute("href"));
	}
	}

}

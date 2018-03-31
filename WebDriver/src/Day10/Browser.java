package Day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Browser {
	public static WebDriver driver = null;
	@Test
	public void br(){
		
			System.setProperty("WebDriver.chrome.driver", "C:\\Chromedriver\\Chromedriver.exe");
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			//driver.getTitle();
			System.out.println(driver.getTitle());
			
			driver.quit();
	}

}

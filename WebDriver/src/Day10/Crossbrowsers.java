package Day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetTitle;


public class Crossbrowsers {
	
	//check out crossbrowser.xml file
	
	public static WebDriver driver = null;
	
	@Parameters("browser")
	@Test
	public void selectBrowser(String browserName){
		
	/*	if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("WebDriver.FireFox.driver",".exe");
			driver = new FirefoxDriver();
		}
		
		else*/ 
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("WebDriver.chrome.driver", "C:\\Chromedriver\\Chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("WebDriver.ie.driver", "C:\\IEDriver\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		//driver.getTitle();
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}

package Day8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class Scroll_JQueryUI {
	
	public static WebDriver driver=null;
	public static  String vURL;
	
	public void scroll() throws InterruptedException{
	
	vURL="https://jqueryui.com/";
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(vURL);
	
	Thread.sleep(5000);
	
	((JavascriptExecutor)driver).executeScript("scroll(0,500)");
	
	Thread.sleep(5000);
	
	((JavascriptExecutor)driver).executeScript("scroll(0,-300)");
	
	//driver.close();
	}
}

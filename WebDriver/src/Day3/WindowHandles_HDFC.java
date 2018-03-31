package Day3;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandles_HDFC {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.hdfcbank.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		Set<String>winids = driver.getWindowHandles();
		Iterator<String>iterator = winids.iterator();
		//System.out.println(winids);
		
		
		Thread.sleep(9000l);
		driver.findElement(By.xpath("html/body/div[1]/div[7]/div/div[1]/div[3]/ul/li[1]/a")).click();
		
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		
		String firstwindowid = iterator.next();
		System.out.println(firstwindowid);
		

		String seccondwindowid = iterator.next();
		System.out.println(seccondwindowid);
		
		Thread.sleep(5000l);
		driver.switchTo().window(seccondwindowid);
		
		driver.close();

		driver.switchTo().window(firstwindowid);
		
	}

}

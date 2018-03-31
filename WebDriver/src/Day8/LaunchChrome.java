package Day8;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		//if path is not set--Illegalstateexception--
		WebDriver driver = new ChromeDriver();
		driver.get("http://bing.com");
		System.out.println(driver.getTitle());
		Set<String>winids = driver.getWindowHandles();
		Iterator<String>iterator = winids.iterator();
		//System.out.println(winids);
		
		
		Thread.sleep(9000l);
		//driver.findElement(By.xpath("html/body/div[1]/div[7]/div/div[1]/div[3]/ul/li[1]/a")).click();
		
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		
		String firstwindowid = iterator.next();
		System.out.println(firstwindowid);
		

		String seccondwindowid = iterator.next();
		System.out.println(seccondwindowid);
		
		Thread.sleep(5000l);
		driver.switchTo().window(seccondwindowid);
		
		driver.close();
	}

}

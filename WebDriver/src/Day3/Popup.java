package Day3;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popup {
		
		public static WebDriver driver = null;
		public static String vURL;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new FirefoxDriver();
			vURL = "http://www.hdfc.com/";
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.navigate().to(vURL);
			Thread.sleep(4);
			closePopUpIfPresent();

	}

		
		public static void closePopUpIfPresent(){
			Set<String> winIds = driver.getWindowHandles();
			System.out.println("Total windows are: "+winIds.size());
			
			if(winIds.size() == 2){
				Iterator<String> itr = winIds.iterator();
				String mainWindowId = itr.next();
				String popupWindowId = itr.next();
				
				driver.switchTo().window(popupWindowId);
				driver.close();
				driver.switchTo().window(mainWindowId);
			}
		}
}

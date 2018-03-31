package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RefreshPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.bing.com");
		Thread.sleep(5000);
		driver.navigate().refresh();
		
		//driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(Keys.F5);

	}

}

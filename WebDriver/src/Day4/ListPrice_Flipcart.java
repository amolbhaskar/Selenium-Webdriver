package Day4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListPrice_Flipcart {

	public static WebDriver driver = null;
	public static String vURL;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.flipkart.com/mobiles/samsung~brand/pr?sid=tyy,4io&otracker=hp_header_nmenu_sub_Electronics_0_Samsung";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		List<WebElement>price = driver.findElements(By.xpath("//span[starts-with(@class,'fk-font-17 fk-bold')]"));
		System.out.println(price.size());
		
		for(WebElement temp : price)
		{
			System.out.println(temp.getText());
		}
		
		driver.close();
		

	}

}

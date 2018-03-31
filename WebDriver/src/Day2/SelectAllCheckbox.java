package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectAllCheckbox {

	public static WebDriver driver;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		 driver=new FirefoxDriver();
		 vURL="http://www.flipkart.com/search?q=tv&otracker=start&as-show=on&as=off";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		Thread.sleep(5000);
		
		List<WebElement>chkbox = driver.findElements(By.xpath("//input[starts-with(@value,'facets.screen_size')]"));
		
		//*[@id='screen_size']/li[2]/a/input
		/*
		for(WebElement temp:chkbox)
		{
			temp.click();
		}*/
		
		for(int i=0; i<chkbox.size(); i++){
			if(!chkbox.get(i).isSelected()){
				chkbox.get(i).click();
			}
		}

}
}

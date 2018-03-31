package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iframes {
	
	public static WebDriver driver=null;
	public static  String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		vURL="http://toolsqa.com/iframe-practice-page/";
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(vURL);
		
		//its findbyelements
		int total_frames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total no.of iframes: "+total_frames);
		
		Thread.sleep(5000);
		//iframe by id
		driver.switchTo().frame("IF1");
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("firstname")).sendKeys("am");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='photo']")).sendKeys("C:\\Users\\abhaskar\\Pictures\\Hawaii.jpg");
		
		Thread.sleep(5000);
		
		//before switch to another iframe 
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		driver.switchTo().frame("IF2");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='ui-id-3']")).click();
		
		
	}

}

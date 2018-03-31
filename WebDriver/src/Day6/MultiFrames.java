package Day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiFrames {
	
	public static WebDriver driver = null;
	public static String vurl = "https://www.paytm.com";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get(vurl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		//find out to which frame I want to work on
	/*	for(int i=0; i<frames.size(); i++){
			driver.switchTo().frame(i);
			int frame_num = driver.findElements(By.xpath("//*[@id='input_0']")).size();
			System.out.println(frame_num);
			driver.switchTo().defaultContent();
			
		}*/
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='input_0']")).sendKeys("1234561230");
		driver.switchTo().defaultContent();
}
}
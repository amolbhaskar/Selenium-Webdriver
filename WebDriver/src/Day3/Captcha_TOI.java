package Day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Captcha_TOI {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://timesofindia.indiatimes.com/tech/tech-news/Alibaba-Future-Group-and-Flipkart-in-race-to-buy-Jabong/articleshow/53040349.cms";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/textarea")).sendKeys("nice");
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/div[1]/div[1]/input[1]")).sendKeys("julie1");
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/div[1]/div[1]/input[2]")).sendKeys("j.ab@aol.com");
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/div[1]/div[1]/input[3]")).sendKeys("patna");
		String captcha = driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/div[1]/div[1]/span/span")).getText();
		System.out.println(captcha);
		
		int first = Integer.parseInt(captcha.substring(0, 1));
		int second = Integer.parseInt(captcha.substring(2, 3));
		
		int number = first+second;
		System.out.println(number);
		
		String temp = Integer.toString(number);
		
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/div[1]/div[1]/span/input")).sendKeys(temp);
		driver.findElement(By.xpath("//*[@id='comment-section-53040349']/div[1]/div/div[3]/input")).click();
		
		//driver.close();
		
	}

}

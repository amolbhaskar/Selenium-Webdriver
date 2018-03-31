package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPress_Gmail {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("bhaskar.amol");
		driver.findElement(By.xpath("//*[@id='next']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id='PersistentCookie']")).click();
		
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='signIn']")).sendKeys(Keys.ENTER);
		
		String error_msg = driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']")).getText();
		System.out.println("error message is: "+error_msg);
		
		driver.close();
		
	}
}

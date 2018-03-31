package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_Rediff {

	public static WebDriver driver = null;
	public static String vURL;
	
	public static void main(String[] args) {
	
		
		driver = new FirefoxDriver();
		vURL = "http://www.rediff.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println("alert is: "+message);
		
		alert.accept();
		alert.dismiss();
		
		//driver.switchTo().window(mainpage);
		
		driver.close();
		

	}

}

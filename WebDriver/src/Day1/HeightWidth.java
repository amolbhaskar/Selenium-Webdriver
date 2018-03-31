package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeightWidth {

	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		//sign in button 
		Dimension d = driver.findElement(By.xpath("//*[@id='u_0_m']")).getSize();
		
		int h = driver.findElement(By.xpath("//*[@id='u_0_m']")).getSize().getHeight();
		int w = driver.findElement(By.xpath("//*[@id='u_0_m']")).getSize().getWidth();
		
		
	}

}

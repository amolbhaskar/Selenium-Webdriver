package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigate_Google {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.google.co.in/?gfe_rd=cr&ei=qtt5V9vyDLDT8gfv3bu4Bg&gws_rd=ssl";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='fsl']/a[1]")).click();
		
		Thread.sleep(5000l);
		driver.navigate().back();
		
		Thread.sleep(5000l);
		driver.navigate().forward();
		
		Thread.sleep(5000l);
		driver.navigate().back();
		
		driver.close();

	}

}

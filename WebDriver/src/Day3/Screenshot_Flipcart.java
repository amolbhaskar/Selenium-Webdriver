package Day3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot_Flipcart {
	
	public static WebDriver driver = null;
	public static String vURL;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		try{
			
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.flipkart.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//a[@href='/account/login?ret=/']")).click();
		driver.findElement(By.xpath("//input[@class='fk-input login-form-input user-email']")).sendKeys("ab@aol.com");
		driver.findElement(By.xpath("//input[@class='fk-input login-form-input user-pwd']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@class='submit-btn login-btn btn']")).click();
		}catch(Exception e)
		{
		
		Thread.sleep(5000l);
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in C drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("C:\\Java_Luna_Projects\\WebDriver\\src\\Screenshot\\screenshot.png"));
            System.out.println(e);
		}
		finally{
            
            driver.close();
		}
	}

}

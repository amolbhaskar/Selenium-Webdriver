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
import org.testng.annotations.Test;

public class TakeScreenshot2 {

	public WebDriver driver = null;

	@Test
	public void takescreenshot() throws IOException {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		try {
			// below statement will throw an exception which will be caught in
			// catch block

			driver.findElement(By.id("test")).sendKeys("testing");
		} catch (Exception e) {

			System.out.println("Exception caught: "+e);
			getscreenshot();

		}
	}

	public void getscreenshot() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in C drive with name "screenshot1.png"
        FileUtils.copyFile(scrFile, new File("C:\\Java_Luna_Projects\\WebDriver\\src\\Screenshot\\screenshot1.png"));
		
		
	}

}

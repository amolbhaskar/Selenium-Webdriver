package Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility 
{
	public static void screenshot(WebDriver driver,String screenshotName)
	{
		try {
			//Use TakesScreenshot interface
			//cant create Object of an interface so typecast and create an object
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			//save scrnshot as a file which is in memory/buffer
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			//use fileutils to save screenshot at a physical location by creating folder Screenshots
			// to add multiple screenshots,use +screenshotName+ and request a parameter String screenshotName
			
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			
			
			
		} catch (Exception e) 
		{
			
			System.out.println("error message while capturing screenshot is: "+ e.getMessage());
		
		}
}
}

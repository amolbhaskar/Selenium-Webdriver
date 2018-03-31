
package Day8;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoIT {

	@Test
	public void uploadFile() throws IOException, InterruptedException
	{
		//Step1. download autoit and script editor
		//step2. install both
		//step3. create a html file using notepad and save as "fileupload.html"...<input type="file", id="1", name="resumeupload"
		//step4. Open AutoIt3 folder-open Au3Info_x64...finder tool
		//step5. open SciTe folder...open SciTe which script editor..write script using controlfocus(),controlsettext(),controlclick()
		//step6. save this file (.au3) and compile to make it .exe file
		//step7. double click .exe file and copy path to use in below script for getRuntime()
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//which file to upload do give filepath
		driver.get("file:///C:/Users/abhaskar/Desktop/AutoIT/fileupload.html");
		
		//how...click on browser button
		driver.findElement(By.xpath("//*[@id='1']")).click();
		
		//execute the script
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\abhaskar\\Desktop\\AutoIT\\FileUpload.exe");
		
		//for multiple file upload...use command line argument
		
	}
	
}

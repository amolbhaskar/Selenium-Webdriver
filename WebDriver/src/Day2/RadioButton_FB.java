package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton_FB {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		//driver.findElement(By.xpath("//*[@id='u_0_f']")).click();
		
		List<WebElement>radiobtn = driver.findElements(By.name("sex"));
		
		String check = radiobtn.get(0).getAttribute("checked");
		if(check.equalsIgnoreCase(null))
		{
			radiobtn.get(0).click();
			
		}
		

		
	}

}

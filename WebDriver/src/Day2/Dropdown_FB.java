package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dropdown_FB {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		driver.findElement(By.xpath("//*[@id='day']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='month']")).sendKeys("Feb");
		driver.findElement(By.xpath("//*[@id='year']")).sendKeys("2000");
		
		WebElement listbox = driver.findElement(By.xpath("//*[@id='day']"));
		
		
		List<WebElement>dropdown = driver.findElements(By.tagName("option"));
		
		System.out.println(dropdown.size());
		
		for(WebElement temp  : dropdown){
			System.out.println(temp.getText());
		}
		
		driver.close();
		
	}

}

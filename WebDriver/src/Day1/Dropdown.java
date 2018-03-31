package Day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static WebDriver driver;
	public static String vURL;

	public static void main(String[] args) {
		
		System.setProperty("WebDriver.gecko.driver", "C:\\Java_Selenium_3.0\\geckodriver.exe");
		driver = new FirefoxDriver();
		vURL = "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		Select select = new Select(driver.findElement(By.id("day")));
		
		//select.selectByVisibleText("Mar");
		select.selectByIndex(1);
		//select.selectByValue(value);
		
		String text=select.getFirstSelectedOption().getText();
		System.out.println(text);
	}


}

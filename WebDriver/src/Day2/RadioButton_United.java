package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton_United {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.cleartrip.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		List<WebElement> allRadios = driver.findElements(By.name("trip_type"));
		System.out.println(allRadios.size());
		
		//driver.findElement(By.xpath("//*[@id='MultiCity']")).click();
		allRadios.get(2).click();
		
		//((JavascriptExecutor) driver).executeScript("document.getElementById('MultiCity').click;");
		//((JavascriptExecutor) driver).executeScript("oneway()");
		
		System.out.println("-----------------");

}
}
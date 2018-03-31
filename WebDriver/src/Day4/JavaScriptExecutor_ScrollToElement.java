package Day4;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor_ScrollToElement {
	
	public static WebDriver driver = null;
	public static String vURL;
	
	@Test
	public void scrolltoElement(){
		
		//System.setProperty("WebDriver.gecko.driver", "C:\\Java_Selenium_3.0\\geckodriver.exe");
		driver = new FirefoxDriver();
		vURL = "http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(vURL);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//*[@id='mCSB_3_container']/p[3]"));
		
		//scroll to the element which is not appeared on the page
		js.executeScript("arguments[0].scrollInToView(true);", element);
		
		//extract the test and verify
		System.out.println(element.getText());
		
		Assert.assertEquals(element.getText(), "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		
		driver.quit();
	}

}

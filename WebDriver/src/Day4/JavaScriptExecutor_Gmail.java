package Day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptExecutor_Gmail {

	public static WebDriver driver = null;
	public static String vURL;
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.americangolf.co.uk/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location = 'http://www.gmail.com'"	);
		js.executeScript("document.getElementById('Email').value='bhaskar.amol'");
		js.executeScript("window.scrollTo(0,100)");
		
	}

}

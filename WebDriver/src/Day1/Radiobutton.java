package Day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Radiobutton {
//same applies to Checkboxes
	
public static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
		driver.navigate().to("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> rdbtn = driver.findElements(By.name("group1"));
		System.out.println(rdbtn.size());
		//by default Attribute value for radiobuttons and checkboxes is "checked"
		System.out.println(rdbtn.get(0).getAttribute("checked"));
		System.out.println(rdbtn.get(1).getAttribute("checked"));
		System.out.println(rdbtn.get(2).getAttribute("checked"));
		System.out.println("----------------------");
		rdbtn.get(0).click();
		System.out.println(rdbtn.get(0).getAttribute("checked"));
		System.out.println(rdbtn.get(1).getAttribute("checked"));
		System.out.println(rdbtn.get(2).getAttribute("checked"));

}
}
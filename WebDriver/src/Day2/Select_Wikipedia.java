package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Wikipedia {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.wikipedia.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='searchLanguage']")));
		
		//select.selectByValue("hi");
		select.selectByVisibleText("Suomi");
		
		List<WebElement>options = select.getOptions();
				System.out.println(options.size());
				
				for(WebElement temp : options){
					System.out.println(temp.getText());
				}
		
	}

}

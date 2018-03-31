package Day1;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static WebDriver driver = null;
	public static String url;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		url = "http://rediff.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.xpath("sdsd")).sendKeys("amol");
		
		Alert alert = driver.switchTo().alert();
		
		List<WebElement>rd = driver.findElements(By.xpath("ff"));
		rd.get(0).getAttribute("checked");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.size();
		
		for(int i=0; i<links.size(); i++){
			links.get(i).getText();
			links.get(i).click();
		}
		for(WebElement temp : links){
			System.out.println(temp.getText());
		}
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		
		String win1 = itr.next();
		
		driver.switchTo().window(win1);
		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().peform();
		
		Random rand = new Random();
		int r = rand.nextInt(links.size());
		links.get(r).click();
		
		act.dragAndDropBy(slider,50 , 0);
		
		Properties prop = new Properties();
		String path = System.getProperty("user.directory")+"\\src\\Day5\\config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		System.out.println(prop.getProperty(win1));
		
		
		
		
 		
		driver.close();

	}

}

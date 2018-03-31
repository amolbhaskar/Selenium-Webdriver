package Day4;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Random_Slider_Golf {

	public static WebDriver driver = null;
	public static String vURL;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://www.americangolf.co.uk/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		Thread.sleep(5000l);
		WebElement mainmenu = driver.findElement(By.xpath("//*[@id='navigation']/nav/ul/li[2]/a"));
		Actions act = new Actions(driver);
		
		Thread.sleep(5000l);
		act.moveToElement(mainmenu).build().perform();;
		
		//click on submenu
		Thread.sleep(5000l);
		//driver.findElement(By.xpath("//*[@id='CLOTHFOOTW_1']/div[1]/ul[3]/li/ul/li[2]/ul/li[3]/a")).click();
		
		WebElement box = driver.findElement(By.xpath("//*[@id='CLOTHFOOTW_1']/div[1]"));
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		
		Random rand = new Random();
		int r= rand.nextInt(links.size());
		links.get(r).click();
		
		
		
	/*	Thread.sleep(5000l);
		WebElement slider = driver.findElement(By.xpath("//*[@id='secondary']/div/div[2]/div[1]/div[1]/div"));
		
		Thread.sleep(5000l);
		act.dragAndDropBy(slider, 50, 0).build().perform();*/
		
		driver.close();
		

	}

}

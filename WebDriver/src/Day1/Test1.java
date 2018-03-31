package Day1;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
	
	public static WebDriver driver = null;
	public static String vURL;
	
	public static WebElement explwait(By locator, int timeout){
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("cd"))));
		return element;
	}

	public static void explwait(WebDriver driver, String id){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("WebDriver.gecko.driver", ".exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://www.rediff.com");
		
		driver.findElement(By.xpath("sds")).sendKeys("ab");
		driver.findElement(By.xpath("ssd")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String message = driver.findElement(By.xpath("hjhj")).getText();
		System.out.println("the alert is: " + message);
		
		alert.accept();
		alert.dismiss();
		
		Select select  = new Select(driver.findElement(By.id("day")));
		select.selectByVisibleText("mon");
		select.selectByIndex(1);
		select.selectByValue("d");
		
		String text = select.getFirstSelectedOption().getText();
		
		System.out.println(text);
		
		org.openqa.selenium.Dimension d = driver.findElement(By.xpath("ll")).getSize();
		
		int h = d.getHeight();
		int w = d.getWidth();
		
		System.out.println(h + " "+ w);
		
		driver.findElement(By.xpath("sdsd")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("ab")).sendKeys(Keys.HOME);
		
		int l = driver.findElement(By.linkText("pop")).getLocation().getX();
		System.out.println(l);
		
		driver.navigate().forward();
		driver.navigate().back();
		
		Test1.explwait(null, 5);
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement temp : links){
			System.out.println(temp.getText());
		}
		
		List<WebElement>attr = driver.findElements(By.tagName("option"));
		System.out.println(attr.size());
		
		for(int i=0; i<attr.size(); i++){
			System.out.println(attr.get(i).getAttribute("lang"));
		}
		
		List<WebElement>rdbtn = driver.findElements(By.xpath("bb"));
		
		String check = rdbtn.get(0).getAttribute("checked");
		
		if(check.equals(null)){
			rdbtn.get(0).click();
		}
		
		for(WebElement all : rdbtn){
			all.click();		
			}
		
		//bootstrap
		List<WebElement>mainmenu = driver.findElements(By.xpath("fgfg"));
		
		for(WebElement ddmenu : mainmenu){
			
			String attribute = ddmenu.getAttribute("innerhtml");
			System.out.println(attribute);
			
			if(attribute.contentEquals("java")){
				ddmenu.click();
				break;
				
			}
		}
		
		//dynamic radio button
		List<WebElement>mainm = driver.findElements(By.xpath("klkl"));
		
		for(WebElement dyn : mainm){
			String temp = dyn.getAttribute("html");
			
			if(temp.equalsIgnoreCase("ruby")){
				dyn.click();
				break;
			}
		}
		
		//windows
		Set<String>winids = driver.getWindowHandles();
		Iterator<String>iterator = winids.iterator();
		
		driver.findElement(By.name("fff")).click();
		
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		String fid = iterator.next();
		System.out.println(fid);
		String sid = iterator.next();
		System.out.println(sid);
		
		driver.switchTo().window(sid);
		
		//actions
		WebElement main = driver.findElement(By.xpath("safdA:"));
		Actions act = new Actions(driver);
		act.moveToElement(main).build().perform();
		act.dragAndDropBy(main, 0, 100).build().perform();
		
		//random link
		List<WebElement>links1 = driver.findElements(By.xpath("dfd"));
		Random rand = new Random();
		int r = rand.nextInt(links1.size());
		links1.get(r).click();
		
		//explwait
		
		explwait(driver, "menu_admin_Qualifications");
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		
		//properties
		Properties prop = new Properties();
		String xpath = System.getProperty("User.dir")+"\\sdfsdf";
		FileInputStream fis = new FileInputStream(xpath);
		prop.load(fis);
		
		
		
		driver.quit();
		

	}

}


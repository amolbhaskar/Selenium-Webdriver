package Day12;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class SaveImage {
 
 public static WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
 }
 
 @AfterTest
public void tearDown() throws Exception { 
  driver.quit();
    } 
 
 @Test
 public void saveimagetest() throws AWTException{
	 
	 WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
	 
	 //right click on the image
	 Actions act = new Actions(driver);
	 act.contextClick(image).build().perform();
	 
	 //copy the image
	 act.sendKeys(Keys.CONTROL, "v").build().perform();
	 
	 //Robot class is used to generate native system input events for the purposes of test automation, 
	 //self-running demos, and other applications where control of the mouse and keyboard is needed.
	 
	 Robot robot = new Robot();
	 
	 //save image to "D:\test"
	 
	 robot.keyPress(java.awt.event.KeyEvent.VK_D);
	 
	// To press : key.
	  robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
	  robot.keyPress(java.awt.event.KeyEvent.VK_SEMICOLON);
	  robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
	  
	  // To press \ key.
	  robot.keyPress(java.awt.event.KeyEvent.VK_BACK_SLASH);
	  
	  // To press "test" key one by one.
	  robot.keyPress(java.awt.event.KeyEvent.VK_T);
	  robot.keyPress(java.awt.event.KeyEvent.VK_E);
	  robot.keyPress(java.awt.event.KeyEvent.VK_S);
	  robot.keyPress(java.awt.event.KeyEvent.VK_T);
	  
	  // To press Save button.
	  robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	  
	 }
	

 }
 


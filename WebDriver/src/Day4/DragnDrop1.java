package Day4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;

public class DragnDrop1 {

	public static void main(String[] args) throws InterruptedException {

		//http://toolsqa.com/selenium-webdriver/drag-drop/
		
		  WebDriver driver = new FirefoxDriver();

		  String URL = "http://sandbox.checklist.com/account/";

		  driver.get(URL);

		  driver.findElement(By.name("j_username")).sendKeys("Username");

		  driver.findElement(By.name("j_password")).sendKeys("Password");

		  driver.findElement(By.name("login")).click();

		  driver.manage().window().maximize();

		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		  WebElement From = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[1]/a/span"));

		  WebElement To = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[4]/a/span"));

		  //using Actions class
		  Actions action = new Actions(driver);

 	      //using Action class
		  Action dragAndDrop = action.clickAndHold(From)
 	    		  					 .moveToElement(To)
 	    		  					 .release(To)
 	    		  					 .build();

 	      						dragAndDrop.perform();
 	      						

	}

}

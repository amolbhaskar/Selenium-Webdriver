package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Visible {
	/*
	 * isDisplayed() is capable to check for the presence of all kinds of web elements available.
isEnabled() is the method used to verify if the web element is enabled or disabled within the webpage.
isEnabled() is primarily used with buttons.
isSelected() is the method used to verify if the web element is selected or not. isSelected() method is pre-dominantly 
used with radio buttons, dropdowns and checkboxes.
	 */
	
	//private static final String Exception = null;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		
		System.setProperty("WebDriver.gecko.driver", "C:\\Java_Selenium_3.0\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		//verify whether search button is displayed
		
		boolean searchButtonPresence = driver.findElement(By.xpath("//input[@value='Google Search']")).isDisplayed();
		System.out.println("search button displayed");
		
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("selenium");
				
		//verify whether search button is displayed and enabled
		boolean btnDisplay = driver.findElement(By.xpath("//input[@value='Google Search']")).isDisplayed();
		boolean btnEnable = driver.findElement(By.xpath("//input[@value='Google Search']")).isEnabled();
		
		if(btnDisplay==true && btnEnable==true){
			
			WebElement searchIcon = driver.findElement(By.xpath("//input[@value='Google Search']"));
			searchIcon.click();
			
		}
		
		Thread.sleep(4000);
		
		driver.quit();
	
	}

}

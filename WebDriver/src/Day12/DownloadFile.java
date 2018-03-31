package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//http://toolsqa.com/selenium-webdriver/how-to-download-files-using-selenium/
//https://www.sitepoint.com/web-foundations/mime-types-summary-list/
//https://developer.mozilla.org/en-US/docs/Archive/Mozilla/Download_Manager_preferences
	
public class DownloadFile {
 WebDriver driver;
 
 @BeforeTest
 public void StartBrowser() {
	 
  //Create object of FirefoxProfile in built class to access Its properties.
  FirefoxProfile fprofile = new FirefoxProfile();
  
  //Set Location to store files after downloading.
  fprofile.setPreference("browser.download.dir", "D:\\WebDriverdownloads");
  fprofile.setPreference("browser.download.folderList", 2);
  
  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
  //MIME stands for Multi-purpose Internet Mail Extensions. A MIME type has two parts: a type and a subtype. PDF File (.pdf) – application/pdf
  fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
    + "application/pdf;" //MIME types Of PDF File.
    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
    + "text/plain;" //MIME types Of text File.
    + "text/csv"); //MIME types Of CSV File.
  fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
  fprofile.setPreference( "pdfjs.disabled", true );
  
  //Pass fprofile parameter In webdriver to use preferences to download file.
  driver = new FirefoxDriver(fprofile);  
 } 
 
 @Test
 public void OpenURL() throws InterruptedException{
	 
  driver.get("http://ambhaskar.trials54.orangehrmlive.com");
  driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
  driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("MO216Tgf");
  driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(Keys.ENTER);
  
  driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']/b")).click();
  driver.findElement(By.xpath("//*[@id='vacancyTableContainer']/table/tbody/tr[2]/td[3]")).click();
  driver.findElement(By.xpath("//*[@id='content']/div[7]/div/table/tbody/tr/td[8]/div/i[1]")).click();

  
  /*  //Download Text File
  driver.findElement(By.xpath("//a[contains(.,'Download Text File')]")).click();
 
  //Download PDF File
  driver.findElement(By.xpath("//a[contains(.,'Download PDF File')]")).click();
  
  //Download CSV File
  driver.findElement(By.xpath("//a[contains(.,'Download CSV File')]")).click();
  
  //Download Excel File
  driver.findElement(By.xpath("//a[contains(.,'Download Excel File')]")).click();
 
  //Download Doc File
  driver.findElement(By.xpath("//a[contains(.,'Download Doc File')]")).click();*/
   
 }
 
/* @AfterTest
 public void CloseBrowser() {  
  driver.quit();  
 }*/
}


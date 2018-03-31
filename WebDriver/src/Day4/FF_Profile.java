package Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//http://www.software-testing-tutorials-automation.com/2014/05/how-to-create-and-use-custom-firefox.html

public class FF_Profile {
 WebDriver driver;
 
 @BeforeTest
 public void StartBrowser() {
  //Create object of webdriver's inbuilt class ProfilesIni to access Its method getProfile.
  ProfilesIni firProfiles = new ProfilesIni();
  //Get access of newly created profile WebDriver_Profile.- use the above link for how to create new profile.
  FirefoxProfile wbdrverprofile = firProfiles.getProfile("WebDriver_Profile");
  //Pass wbdrverprofile parameter to FirefoxDriver.
  driver = new FirefoxDriver(wbdrverprofile);  
 }
 
 @Test
 public void OpenURL(){
  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");  
 }
 
 @AfterTest
 public void CloseBrowser() {
  driver.quit();  
 }
}

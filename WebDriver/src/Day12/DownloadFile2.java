package Day12;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DownloadFile2 {

		public static void main(String[] args) throws InterruptedException {
			    //Create FireFox Profile object
				FirefoxProfile profile = new FirefoxProfile();
				
				profile.setPreference("browser.download.folderList", 2);
				
				//Set Location to store files after downloading.
				profile.setPreference("browser.download.dir", "D:\\WebDriverDownloads");
				

				//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/html;"); 

			/*	profile.setPreference( "browser.download.manager.showWhenStarting", false );
				profile.setPreference( "pdfjs.disabled", true );*/

				//Pass FProfile parameter In webdriver to use preferences to download file.
				FirefoxDriver driver = new FirefoxDriver(profile);  

				driver.get("http://ambhaskar.trials54.orangehrmlive.com");
				  driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
				  driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("MO216Tgf");
				  driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(Keys.ENTER);
				  
				  driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']/b")).click();
				  driver.findElement(By.xpath("//*[@id='vacancyTableContainer']/table/tbody/tr[2]/td[3]")).click();
				  driver.findElement(By.xpath("//*[@id='content']/div[7]/div/table/tbody/tr/td[8]/div/i[1]")).click();

				  

				//Halting the execution for 5 secs to donwload the file completely
				Thread.sleep(5000);

				//driver.close();

			}

		}

	



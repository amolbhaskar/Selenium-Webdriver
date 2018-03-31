package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebTable {
	
	
	public static WebDriver driver = null;
	public static String vurl = "http://testab.trials53.orangehrmlive.com";

	public static void main(String[] args) 
	{
		
	String username = "Admin";
	String password= "39EbYL7Z";
	String skillName = "aloha";
	String description="test by aloha";
	
	driver = new FirefoxDriver();
	driver.get(vurl);
	driver.manage().window().maximize();
	
	//login page
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	
	expliciteWait(driver, "menu_admin_viewAdminModule");
	
	//home page
	driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	
	expliciteWait(driver, "menu_admin_Qualifications");
	driver.findElement(By.id("menu_admin_Qualifications")).click();
	
	
	driver.findElement(By.id("menu_admin_viewSkills")).click();

	//add  skill
	driver.findElement(By.id("btnAdd")).click();
	driver.findElement(By.id("skill_name")).sendKeys(skillName);
	driver.findElement(By.id("skill_description")).sendKeys(description);
	driver.findElement(By.id("btnSave")).click();
	
	//*[@id='recordsListTable']/tbody/tr[1]/td[2]/a/a
	//*[@id='recordsListTable']/tbody/tr[2]/td[2]/a/a
	//*[@id='recordsListTable']/tbody/tr[5]/td[2]/a/a

	
	String xpath_start="//*[@id='recordsListTable']/tbody/tr[";
	String xpath_end="]/td[2]/a/a";
	int i=2;
	
	while(isElementPresent(xpath_start+i+xpath_end))
	{
		//get first name
		String fskillName = driver.findElement(By.xpath(xpath_start+i+xpath_end)).getText();
		
		if(fskillName.equalsIgnoreCase(skillName))
		{
			System.out.println("First name is: "+ fskillName);
			break;
		}
		
		i++;
	}
	
}
	
	public static boolean isElementPresent(String elexpath)
	{
		int count = driver.findElements(By.xpath(elexpath)).size();
		if(count == 0)
		{
			System.out.println(count);
			return false;
		}else
		{
			return true;
		}
	}
	
	public static void expliciteWait(WebDriver driver, String id)
	{
		
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	
}
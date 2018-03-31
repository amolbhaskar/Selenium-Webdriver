package Day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amol.ddf.orange.Orange_ddf.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basetest1 {
	public WebDriver driver;
	public Properties prop1;
	
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	
	
	/***********Generic functions***************/
	
	public void init() throws IOException{
		if(prop1==null){
			prop1 = new Properties();
			try {
				FileInputStream fis = new FileInputStream(System.getProperty("User dir")+"//src//test//resources//projectconfig.properies");
				prop1.load(fis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
		}
		
		
	}

	public void openBrowser(String brType){
		
		if(brType.equals("Mozilla")){
			System.setProperty("webdriver.Gecko.driver", ".exe");
			driver = new FirefoxDriver();
		}else if(brType.equals("Chrome")){
			System.setProperty("webdriver.Chrome.driver", ".exe");
			driver = new ChromeDriver();
		}else if(brType.equals("IE")){
			System.setProperty("webdriver.IE.driver", ".exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		}
	

	public void navigate(String urlkey){
		driver.get(prop1.getProperty(urlkey));
		
	}
	
	public void type(String locatorKey, String data){
		getElement(locatorKey).sendKeys(data);
	}

	public void click(String locatorKey){
		getElement(locatorKey).click();
	}
	
	public void clear(String locatorKey){
		getElement(locatorKey).clear();
	}
	
	public WebElement getElement(String locatorKey){
		
		WebElement e = null;
		
		try{
			if(locatorKey.endsWith("_id")){
			e = driver.findElement(By.id(prop1.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")){
			e = driver.findElement(By.name(prop1.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")){
			e = driver.findElement(By.xpath(locatorKey));
		}else{
			reportFailure("locator not found: "+locatorKey);
			Assert.fail();
		}
	}catch(Exception ex){
			
			reportFailure(ex.getMessage());
			Assert.fail();
		}
		return e;
	}
	
	/******************Validation Functions**************/
	
	public boolean isElementPresent(String locatorKey){
		
		test.log(LogStatus.INFO, "Checking if element is present: "+ locatorKey);
		List<WebElement> eleList = null;
		
		if(locatorKey.endsWith("_id")){
			eleList = driver.findElements(By.id(prop1.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")){
			eleList = driver.findElements(By.name(prop1.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")){
			eleList = driver.findElements(By.xpath(locatorKey));
		}else{
			reportFailure("locator not found: "+locatorKey);
			Assert.fail();
		}
		if(eleList.size() == 0){
			test.log(LogStatus.INFO, "element is not present: "+ locatorKey);
			return false;
		
		}
		else{
			test.log(LogStatus.INFO, "element is present: "+ locatorKey);
			return true;
		
		}
	}

	
	public void verifyTitle(String data){
		
	}
	
	public boolean verifyText(String locatorKey, String expectedTextKey){
		
		String act_text = getElement(locatorKey).getText().trim();
		String exp_text = prop1.getProperty(expectedTextKey);
		
		if(act_text.equals(act_text))
			return true;
		else
			return false;
			
		}
	
	public void wait(int timeInSec){
		try {
			Thread.sleep(timeInSec * 10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String state = (String)js.executeScript("return document.readyState");
		
		if(!state.equals("complete"))
			wait(1);
			state = (String)js.executeScript("return document.readyState");
	}
	
	/******************Reporting Functions**************/
	
	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}
	
	public void reportFailure(String msg){
		test.log(LogStatus.FAIL, msg);
		takescreenshot();
		Assert.fail(msg);
		
	}
	
	public void takescreenshot(){
		Date d = new Date();
		String screenshotfilename = d.toString().replace(":", "_").replace(" ", "_")+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotfilename));
		}catch(IOException e){
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Screenshot -->"+test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotfilename));
		
	}
	
	/******************App Functions**************/
	
	public boolean doLogin(String uname, String pwd){
		
		test.log(LogStatus.INFO, "Login to the app");
		
		type("loginid_xpath", uname);
		type("password_xpath", pwd);
		click("signin_xpath");
		
		if(isElementPresent("adminlink_xpath"))
			return true;
		else
			return false;
	}
	
	public int getLeadRowNum(String lName){
		List<WebElement> allLead = driver.findElements(By.xpath(prop1.getProperty("vendortablename_xpath")));
		for(int i=0; i<allLead.size(); i++){
			if(allLead.get(i).getText().equals(lName))
				return (i+1);
		}
		return -1;
	}
	
	public void clickonLead(String lName){
		int rNum = getLeadRowNum(lName);
		driver.findElement(By.xpath(prop1.getProperty("vendortablename1_xpath")+rNum+prop1.getProperty("vendortablename2_xpath"))).click();
	}
	
	public void selectDate(String d){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date dateToBeSelected = sdf.parse(d);
			Date currentDate = new Date();
			
			sdf = new SimpleDateFormat("MM");
			String monthToBeSelected = sdf.format(dateToBeSelected);
			sdf = new SimpleDateFormat("yyyy");
			String yearToBeSelected = sdf.format(dateToBeSelected);
			sdf = new SimpleDateFormat("dd");
			String dayToBeSelected = sdf.format(dateToBeSelected);
			
			String month_year = monthToBeSelected+" "+yearToBeSelected;
			
			while(true){
				if(currentDate.compareTo(dateToBeSelected)) == 1)
						click("back");
				else if(currentDate.compareTo(dateToBeSelected) == -1)
					click("forward");
				if(month_year.equals(getText("mn_xpath")))
					break;
			}
			
			driver.findElement(By.xpath("//td[text()='"+dayToBeSelected+"']")).click;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
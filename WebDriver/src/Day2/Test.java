package Day2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Day5.ExpliciteWait;

public class Test {

	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {

		driver = new FirefoxDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement>all_cb = driver.findElements(By.id("cbox"));
		for(int i=0; i<all_cb.size();i++){
			if(!all_cb.get(i).isSelected()){
				all_cb.get(i).click();
			}
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));

		List<WebElement> list = driver.findElements(By.tagName("option"));

		for (WebElement linklist : list) {
			System.out.println(linklist.getText());
		}
		
		List<WebElement>attr_list = driver.findElements(By.tagName("option"));
		
		for(int i=0; i<attr_list.size();i++){
			System.out.println(attr_list.get(i).getAttribute("lang"));
		}
		
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer']"));
		
		List<WebElement>footer_links = driver.findElements(By.tagName("a"));
		System.out.println(footer_links.size());
		
		int flinks = footer_links.size();
		
		for(int i=0; i<flinks; i++){
			System.out.println(footer_links.get(i).getAttribute("href"));
		}
		
		Dimension d = driver.findElement(By.xpath("//div[@class='footer']")).getSize();
		int h =driver.findElement(By.xpath("//div[@class='footer']")).getSize().getHeight();
		
		driver.findElement(By.xpath("//div[@class='footer']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@class='footer']")).click();
		driver.navigate().back();
		
		Select select = new Select(driver.findElement(By.xpath("//div[@class='footer']")));
		select.selectByVisibleText("April");
		
		List<WebElement>allchkbox = driver.findElements(By.xpath("//input[starts-with(@value,'facets.screen_size')]"));
		//int ac = allchkbox.size();
		
		for(WebElement temp : allchkbox){
			temp.click();
		}
		
		List<WebElement>rdbtn = driver.findElements(By.name("name"));
		String check = rdbtn.get(0).getAttribute("checked");
		
		if(check.equalsIgnoreCase(null)){
			rdbtn.get(0).click();
		}
		
		public void elementgetVisible(String locator, int timeout){
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable("//div[@class='footer']"));
			element.click();
	}
	
		//bootstrap
		
		driver.findElement(By.xpath("//input[starts-with(@value,'facets.screen_size')]")).click();
		
		List<WebElement>bootlist = driver.findElements(By.xpath("//input[starts-with(@value,'facets.screen_size')]"));
		
		for(WebElement menu : bootlist){
			String bl = menu.getAttribute("innerhtml");
			System.out.println(bl);
			
			if(bl.contentEquals("selenium")){
				menu.click();
			}
		}
		
		String captcha=driver.findElement(By.xpath("//input[starts-with(@value,'facets.screen_size')]"));
		
		int first = Integer.parseInt(captcha.substring(0, 1));
		int second = Integer.parseInt(captcha.substring(2, 3));
		
		int total = first+second;
		String totalcaptcha = Integer.toString(total);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('departureDate').value = '10/20/2016'");
		js.executeScript("document.querySelector('#returnDate').value='12/25/2016'");
		js.executeScript("window.location='http://www.gmail.com'");
		js.executeScript("document.getElementById('email').value='ab@aol.com'");
		js.executeScript("window.scrollTo(0,100)");
		
		//dynamic radio button
		
		List<WebElement>radiodbtn = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		for(WebElement rdbtnlist : radiodbtn){
			String temp = rdbtnlist.getAttribute("id");
			System.out.println(temp);
			
			if(temp.contains("ruby")){
				rdbtnlist.click();
			}
		}
		
		driver.navigate().refresh();
		
		//windowhandles
		Set<String>winids = driver.getWindowHandles();
		Iterator<String>iterator= winids.iterator();
		
		winids = driver.getWindowHandles();
		iterator= winids.iterator();
		
		String fwinid = iterator.next();
		System.out.println(fwinid);
		
		String swinid = iterator.next();
		System.out.println(swinid);
		
		driver.switchTo().window(swinid);
		
		WebElement mainmenu = driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[1]/a/span[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(mainmenu).build().perform();
		
		List<WebElement>alllinks = driver.findElements(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[1]/a/span[1]"));
		
		Random rand = new Random();
		int r = rand.nextInt(alllinks.size());		
		alllinks.get(r).click();
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[1]/a/span[1]"));
		
		expliciteWait(driver, "menu_admin_Qualifications");
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		
		act.dragAndDropBy(mainmenu, 300, 0).build().perform();
	
		Properties prop = new Properties();
		String path = System.getProperty("User.dir")+"\\src\\Day5\\config.properties";
		System.out.println(System.getProperty("User.dir"));
		
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		//db connection
		String fname = "amol";
		String lname = "bhaskar";
		String city = "kopargaon";
		String zip = "90909";
		
		String vurl = "http://www.loginform.com";
		
		driver.findElement(By.id("fname")).sendKeys(fname);;
		driver.findElement(By.id("lname")).sendKeys(lname);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zip")).sendKeys(zip);
		
		//jdbc api
		String dburl = "jdbc:mysql://localhost:3306/";
		String dbname = "mydb";
		String username = "root";
		String password = "root";
		String query = "Select * from customer";
		
		//load driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//make a conn
		Connection conn = DriverManager.getConnection(dburl+dbname, username,password);
		
		//statement
		Statement stmt = conn.createStatement();
		ResultSet result= stmt.executeQuery(query);
		result.next();
		
		if(result.getString("fname")).equalsIgnoreCase(fname)
			System.out.println("incorrect fname");
		conn.close();
		
		
		String link = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td/a")).getText();
		List<WebElement>colinks = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td/a"));
		List<WebElement>coprice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td/a"));
		
		for(int i=0; i<colinks.size(); i++){
			colinks.get(i).getText().equalsIgnoreCase(link);
			System.out.println(colinks.get(i).getText()+"========="+coprice.get(i).getText());
		}
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		driver.navigate().to("www.bing.com");
		
	
	}

	public static void expliciteWait(WebDriver driver, String id)
	{
		(new WebDriverWait(driver,5))
			.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
}

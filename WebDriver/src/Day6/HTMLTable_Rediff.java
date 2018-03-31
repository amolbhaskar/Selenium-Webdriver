package Day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HTMLTable_Rediff {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);

		String link = driver.findElement(By.xpath("//a[@href='http://money.rediff.com/companies/amtek-auto-ltd/10660001']")).getText();
		
		List<WebElement>company = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td/a"));
		System.out.println(company.size());
		
		List<WebElement> price = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
		System.out.println(price.size());
		
		for(int  i =1; i<company.size(); i++){
			
			if(company.get(i).getText().equalsIgnoreCase(link)){
				
				System.out.println(company.get(i).getText()+"----------"+price.get(i).getText());
				
				
			}
			
			
			
		}
	
	
	
	}

}

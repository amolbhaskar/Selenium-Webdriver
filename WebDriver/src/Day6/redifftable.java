package Day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class redifftable {
	
	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriver driver = new FirefoxDriver();
		vURL = "http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		String companyname=  "Shriram Trans.Fi";
		List<WebElement> cnames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> cprices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		System.out.println(cnames.size());
		System.out.println(cprices.size());
		
		for(int i=0; i<cnames.size(); i++){
			if(cnames.get(i).getText().equals(companyname)){
				System.out.println(cnames.get(i).getText()+"-----------"+cprices.get(i).getText());
				break;
			}
		}
		
		int row = getRowWithCellData("487.65");
		System.out.println(row);
		
	}
	
	public static int getRowWithCellData(String data){
		
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r=1; r<=rows; r++){
			List<WebElement> celldata = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td"));
			for(int c=0; c<celldata.size(); c++){
				String text = celldata.get(c).getText();
				System.out.print(text + "---");
				if(text.equals(data)){
					return r;
				}
			}
			System.out.println();
		}
				return 0;
	}
	
	public static int getrow(String data){
		int rn = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		int cn = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		
		for(int rr = 1; rr<=rn; rr++){
			List<WebElement> cell = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+rr+"]/td"));
			for(int cc=0; cc<cell.size(); cc++){
				String txt = cell.get(cc).getText();
				System.out.print(txt+"---");
				if(txt.equals(data)){
					return rr;
				}
			}
			System.out.println();
			}
		return 0;
	}
}

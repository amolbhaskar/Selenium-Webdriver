package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {
	public static WebDriver driver = null;
	@Test
	public void dytable(){
		
		WebElement table = driver.findElement(By.xpath("//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
		
		List<WebElement>rows = table.findElements(By.tagName("tr"));
		
		for(int row=1; row<rows.size(); row++){
			
			List<WebElement>cols = rows.get(row).findElements(By.tagName("td"));
			
				for(int col=0; col<cols.size(); col++){
					
						String value = cols.get(col).getText();
				}
		}
		
	}
}

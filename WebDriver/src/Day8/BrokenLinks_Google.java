package Day8;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks_Google {
	
	

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com");
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i = 0; i<links.size(); i++)
		{
			String url = links.get(i).getAttribute("href");
			/*WebElement element = (links.get(i));
			String url = element.getAttribute("href");*/
			verifyLinkActive(url);
		}
	}
		public static void verifyLinkActive(String linkURL) throws IOException{
			
			//tell which url to connect to
			URL url = new URL(linkURL);
			
			//makes a request to open a connection
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(3000);
			conn.connect();
			
			
			if(conn.getResponseCode()==200){
				System.out.println(linkURL+"---"+conn.getResponseMessage());
			}
			if(conn.getResponseCode()==400){
				System.out.println(linkURL+"-----"+conn.getResponseMessage()+"-----"+conn.HTTP_NOT_FOUND);
			}
			
		}
		

	}



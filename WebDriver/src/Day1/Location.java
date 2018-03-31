package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Location {

	public static WebDriver driver = null;
	public static String vURL;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		vURL = "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(vURL);
		
		//locate sign in button using x & y co-ordinates
		int p = driver.findElement(By.xpath("//*[@id='u_0_m']")).getLocation().getX();
		//Point p = driver.findElement(By.xpath("//*[@id='u_0_m']")).getLocation();
		System.out.println(p);

		//int x= p.getX();
		//int y = p.getY();
				
		//System.out.println(x);
		//System.out.println(y);
	}

}

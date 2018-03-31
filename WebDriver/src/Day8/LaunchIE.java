package Day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchIE {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://cricinfo.com");
		System.out.println(driver.getTitle());
			

	}

}

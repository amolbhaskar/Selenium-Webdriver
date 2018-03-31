package Day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Properties_Gmail {

	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		Properties prop = new Properties();
		//String xpath = "C:\\Java_Luna_Projects\\WebDriver\\src\\Day5\\config.properties";
		String xpath = System.getProperty("user.dir") + "\\src\\Day5\\config.properties";
		FileInputStream fis = new FileInputStream(xpath);
		prop.load(fis);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		

	}

}

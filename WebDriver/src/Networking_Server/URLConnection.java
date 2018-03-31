package Networking_Server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public class URLConnection {

	public static void main(String[] args) throws IOException {
		
		java.net.URL url = new java.net.URL("http://www.yahoo.com/index.html");
		
		java.net.URLConnection conn = url.openConnection();
		
		//display the date
		System.out.println("Date: "+ new Date(conn.getDate()));
		
		//display expirydate
		System.out.println("Expiry date: "+ new Date(conn.getExpiration()));
		
		//display content-length
		System.out.println("Content-length: "+conn.getContentLength());

	}

}

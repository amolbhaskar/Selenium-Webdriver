package Networking_Server;

import java.net.*;

public class URL {

	public static void main(String[] args) throws MalformedURLException {

		// 1. protocol
		// 2. name or ip address
		// 3. port number
		// 4. file name

		// URL obj = new java.net.URL(String protocol,String host, int port, String path)

		java.net.URL obj = new java.net.URL("http://www.guru99.com/all-about-testng-and-selenium.html");

		System.out.println("Protocol: " + obj.getProtocol());
		System.out.println("Host name: " + obj.getHost());
		System.out.println("Port: " + obj.getPort());
		System.out.println("File name: " + obj.getFile());
		System.out.println("External form: " + obj.toExternalForm());

	}

}

package Networking_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("please enter web address: ");

		String site = br.readLine();
		
		//getByName() method accepts site name and returns its ip address
		try {
			InetAddress ip = InetAddress.getByName(site);

			System.out.println("The ip address is: " + ip);
			
		} catch (UnknownHostException ue) {

			System.out.println("website not found");
		}
	}
}

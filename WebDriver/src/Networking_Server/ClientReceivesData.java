package Networking_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientReceivesData {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//create client socket
		Socket s = new Socket("localhost", 777);
		
		//socket receiving data
		InputStream obj = s.getInputStream();
		
		//send data from socket to client 
		BufferedReader br = new BufferedReader(new InputStreamReader(obj));
		
		//receive strings
		boolean str;
		while(str = br.readLine() != null)
			System.out.println("From server: "+ str);
		
		//close connection
		br.close();
		s.close();
			
	}

}

package Networking_Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TwoWayCommClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 777);
		
		//to send data to the server
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		//to read data coming from the server
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//to read data from the keyboard which will be send to server
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		String str, str1;
		
		//repeat as  long as exit is not typed at client
		while(!(str = kb.readLine()).equals("exit"))
		{
			dos.writeBytes(str+"\n");
			str1 = br.readLine();
			System.out.println(str1);
		}
		
		//close connection
		dos.close();
		br.close();
		kb.close();
		
	}

	
}

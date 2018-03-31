package Networking_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TwoWayCommServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(777);
		
		Socket s = ss.accept();
		System.out.println("connection established");
		
		//to send data to client
		PrintStream ps = new PrintStream(s.getOutputStream());
		
		//to read data coming from client
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//writing response back to client using keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			String str, str1;
			
			//str = reading data sent by client
			while ((str = br.readLine()) != null); 
				{
					
					//str1 = server response back to client
					str1 = kb.readLine();
					ps.println(str1);
				}
				
				//close connection
				ps.close();
				br.close();
				kb.close();
				ss.close();
				s.close();
		}

	}

}

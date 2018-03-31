package RetrievingaFile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_Program {

	public static void main(String[] args) throws IOException, IOException {
		
		//create client socket
		Socket s  = new Socket("localhost", 8888);
		
		//accept filename from keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter file name: ");
		String fname = kb.readLine();
		
		//send file name to the server
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		out.writeBytes(fname+"\n");
		
		//to read data coming from the server
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String str;
		
		//read first line from server into str
		str = in.readLine();
		
		//if file is found, server returns "Yes" else "No"
		if(str.equals("Yes")){
			
			//read and display the file contents coming from the server
			while((str = in.readLine()) != null)
				
				System.out.println(str);
			
		}
		else{
			System.out.println("File not found");
		}


		//close connection by closing the streams
		kb.close();
		out.close();
		in.close();
		s.close();
	}

}

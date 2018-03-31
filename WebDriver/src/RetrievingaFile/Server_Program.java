package RetrievingaFile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Program {

	public static void main(String[] args) throws IOException {

		// create a server socket
		ServerSocket ss = new ServerSocket(8888);

		// make the server wait till client accepts connection
		Socket s = ss.accept();
		System.out.println("connection established");

		//to accept filename from client
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//to send file contents to client
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
		//read the filename from the client
		String fname = br.readLine();
		
		FileReader fr = null;
		BufferedReader file = null;
		boolean flag;
		
		//create File class object with filename
		File f = new File(fname);
		
		//test if file exists or not
		if(f.exists()){
			flag = true;
		}else{
			flag=false;
		}
		
		//if file exists, send "Yes" to client else send "No" to client
		if(flag=true){
			out.writeBytes("Yes"+"\n");
		}
		else{
			out.writeBytes("No"+"\n");
		}
		
		if(flag == true){
			
			//attach file to filereader to read data
			fr = new FileReader(f);
			
			//attach filereader to bufferedreader
			file = new BufferedReader(fr);
			
			String str;
			
			//read the contents of the file from the BufferedReader and write to DataOutputStream
			while((str = file.readLine()) != null)
			{
				out.writeBytes(str + "\n");
			}
			
			out.close();
			file.close();
			fr.close();
			s.close();
			ss.close();
			
		}
	}

}

package Networking_Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSendsData {

	public static void main(String[] args) throws IOException {
		
		//create a server socket with a port number
		ServerSocket ss = new ServerSocket(777);
		
		//let the server wait till a client accepts a connecction
		Socket s = ss.accept();
		
		System.out.println("connection established");
		
		//stream is used by socket to send data to client
		OutputStream obj = s.getOutputStream();
		
		//send data to the socket
		PrintStream ps = new PrintStream(obj);
		
		//send 2 strings to the client
		String str = "Hello Client";
		ps.println(str);
		ps.println("bye");
		
		//close connection by closing the stream and sockets
	
		ps.close();
		ss.close();
		s.close();

	}

}

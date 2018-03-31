package TextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jboss.netty.handler.queue.BufferedWriteHandler;

public class ReadDataTypes {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("D://temp1.txt");
/*		try {
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fwrite);
			
			br.write("line11");
			br.newLine();
			br.write("line22");
			
			br.flush();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		
		String name="";
		int age=0;
		double salary=0.0;
		
		
		try {
			FileReader fread = new FileReader(file);
			BufferedReader bread = new BufferedReader(fread);
			
				
			while((name=bread.readLine()) != null){
				
				age = Integer.parseInt(bread.readLine());
				salary = Double.parseDouble(bread.readLine());
				
				System.out.println("name= "+name + "\t"+ "age = "+age+"\t"+"salary= "+salary);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}

package TextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteTextFile {

	public static void main(String[] args) throws IOException {
		//creating
		File file = new File("D://Temp.txt");
		file.createNewFile();
		
		//writing
		FileWriter w = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(w);
		out.write("Writing the first line.");
		out.newLine();
		out.write("Writing the second line.");
		out.flush();
		
		//reading
		FileReader r = new FileReader("D://Temp.txt");
		BufferedReader br = new BufferedReader(r);
		String x = "";
		
		/*System.out.println(br.readLine());
		System.out.println(br.readLine());*/
		
		while((x = br.readLine()) != null){
			System.out.println(x);
		}
	}

}

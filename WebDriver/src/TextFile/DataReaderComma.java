package TextFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DataReaderComma {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName= "D://Stocks.txt";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		//sc.next();//ignore the first line eg. close
		
		while(sc.hasNext()){
			
			String data = sc.next();
			String[] val = data.split(",");
			
			/*double closingValue = Double.parseDouble(val[4]);
			System.out.println(closingValue);*/
			
			System.out.println(val[4]);//printing close values
		}
	}


}

package TextFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CompareFiles {

	public int compareFile(String fILE_ONE2, String fILE_TWO2)throws Exception 
	{

	File f1 = new File(fILE_ONE2); //OUTFILE
	File f2 = new File(fILE_TWO2); //INPUT

	FileReader fR1 = new FileReader(f1);
	FileReader fR2 = new FileReader(f2);

	BufferedReader reader1 = new BufferedReader(fR1);
	BufferedReader reader2 = new BufferedReader(fR2);

	String line1 = null;
	String line2 = null;
	int flag=1;
	while ((flag==1) &&((line1 = reader1.readLine()) != null)&&((line2 = reader2.readLine()) != null)) 
	{
	    if (!line1.equalsIgnoreCase(line2))  
	        flag=0;
	    else 
	        flag=1;   
	}
	reader1.close();
	reader2.close();
	return flag;


	}
}

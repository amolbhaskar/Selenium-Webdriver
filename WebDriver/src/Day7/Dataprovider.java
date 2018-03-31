package Day7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//all dataproviders for all tests
public class Dataprovider {
	
	@DataProvider(name="regTestDataProvider")
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		data[0][0] = "U1";
		data[0][1] = "P1";
		data[0][2] = "abc@gmail.com";
		
		data[1][0] = "U2";
		data[1][1] = "P2";
		data[1][2] = "xyz@aol.com";
		
		return data;
	}

}

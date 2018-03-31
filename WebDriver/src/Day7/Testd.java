package Day7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testd {
	
	@Test(dataProvider="getData")
	public void param(String a1, String a2, String a3){
		System.out.println();
	}
	
	@DataProvider()
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0] ="u1";
		data[0][1] = "p1";
		data[0][2] ="t1";
		data[1][0] = "u2";
		data[1][1] ="p2";
		data[1][2] = "t2";
		
		return data;
	}

}

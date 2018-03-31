package Day7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Parameterization_TestNG {

	
	
	@Test(dataProvider="getData")
	public void TestLogin(String username,String password)//no.of input parametrs = no. of cols
	{
		System.out.println();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "ab1";
		data[0][1] = "xx1";
		
		
		data[1][0] = "ab2";
		data[1][1] = "xx2";
		
		
		data[2][0] = "ab3";
		data[2][1] = "xx3";
		
		return data;
		
	}
}
